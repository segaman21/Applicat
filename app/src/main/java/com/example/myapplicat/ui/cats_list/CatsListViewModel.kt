package com.example.myapplicat.ui.cats_list

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicat.data.model.ModelCategories
import com.example.myapplicat.data.network.Repository
import kotlinx.coroutines.launch

class CatsListViewModel : ViewModel() {
    private val _catsLiveData = MutableLiveData<List<ModelCategories>>()
    val catsLiveData: LiveData<List<ModelCategories>> get() = _catsLiveData
    private val repository = Repository()

    fun getAllCats(context: Context) {
        viewModelScope.launch {
            _catsLiveData.value = repository.loadAllCats(context)
        }
    }
}