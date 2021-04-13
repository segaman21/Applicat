package com.example.myapplicat.ui.cats_details

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicat.data.model.ModelCategories
import com.example.myapplicat.data.network.Repository
import kotlinx.coroutines.launch

class CatDetailsViewModel : ViewModel() {

    private val _catsDetLiveData = MutableLiveData<List<ModelCategories>>()
    val catsDetLiveData: LiveData<List<ModelCategories>> get() = _catsDetLiveData
    private val repository = Repository()

    fun getDetCats(context: Context, catId: String?) {
        viewModelScope.launch {
            _catsDetLiveData.value = repository.getCats(context,catId)
        }
    }
}
