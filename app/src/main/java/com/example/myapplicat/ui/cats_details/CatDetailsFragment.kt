package com.example.myapplicat.ui.cats_details
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.myapplicat.data.model.ModelCategories
import com.example.myapplicat.databinding.DetailsFragmentBinding
import kotlinx.android.synthetic.main.details_fragment.*
import android.os.Environment
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.myapplicat.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

class CatDetailsFragment : Fragment() {
    private val viewModel by viewModels<CatDetailsViewModel>()
    private var _binding: DetailsFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DetailsFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageId = arguments?.getString("IMAGE_ID")
        val catId = arguments?.getString("CAT")

        viewModel.getCatDetails(requireActivity(), catId)
        viewModel.catsDetLiveData.observe(viewLifecycleOwner, { cats ->
            bind(cats, imageId)
            binding?.buttonSaveImage?.setOnClickListener {
                givePermission()
                CoroutineScope(Dispatchers.IO).launch {
                    val picture: Bitmap = downloadPic(imageId)
                    saveImage(picture, cats)
                }
                Toast.makeText(context, "Image Saved", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun givePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R && !Environment.isExternalStorageManager()) {
            val uri = Uri.parse("package:" + BuildConfig.APPLICATION_ID)
            startActivity(
                Intent(
                    Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION,
                    uri
                )
            )
        }
    }

    private fun downloadPic(imageId: String?): Bitmap {
        return Glide.with(this)
            .asBitmap()
            .load(imageId)
            .placeholder(android.R.drawable.progress_indeterminate_horizontal)
            .error(android.R.drawable.stat_notify_error)
            .submit()
            .get()
    }

    private fun bind(cats: ModelCategories, imageId: String?) {
        binding?.nameText?.text = cats.name
        binding?.originText?.text = cats.origin
        binding?.descriptionText?.text = cats.description
        binding?.lifeText?.text = cats.life
        cat_picture.let {
            Glide.with(this)
                .load(imageId)
                .into(it)
        }
    }

    private fun saveImage(image: Bitmap, cat: ModelCategories): String? {
        var savedImagePath: String? = null
        val imageFileName = cat.name
        val storageDir = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString()
        )
        var success = true
        if (!storageDir.exists()) {
            success = storageDir.mkdirs()
        }
        if (success) {
            val imageFile = File(storageDir, imageFileName)
            savedImagePath = imageFile.absolutePath
            try {
                val fOut: OutputStream = FileOutputStream(imageFile)
                image.compress(Bitmap.CompressFormat.PNG, 100, fOut)
                fOut.flush()
                fOut.close()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            galleryAddPic(savedImagePath)
        }
        return savedImagePath
    }

    private fun galleryAddPic(imagePath: String?) {
        imagePath?.let { path ->
            val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
            val f = File(path)
            val contentUri: Uri = Uri.fromFile(f)
            mediaScanIntent.data = contentUri
        }
    }
}
