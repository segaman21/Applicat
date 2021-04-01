package com.example.myapplicat.ui

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicat.data.model.Model
import com.example.myapplicat.data.network.Repository
import kotlinx.coroutines.launch

class FirstViewModel : ViewModel() {
    private val _catsLiveData = MutableLiveData<List<Model>>()
    val catsLiveData: LiveData<List<Model>> get() = _catsLiveData
    private val repository = Repository()

    fun getCats(context: Context) {
        viewModelScope.launch {
            _catsLiveData.value = repository.loadCats(context)
        }
    }
}