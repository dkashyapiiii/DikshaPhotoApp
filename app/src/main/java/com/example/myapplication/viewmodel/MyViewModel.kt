package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Photos
import com.example.myapplication.repository.MyRepository
import com.example.myapplication.repository.MyRepositoryImplementation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor
    (private val repository: MyRepository):ViewModel(){
    val pList : MutableLiveData<Response<List<Photos>>> = MutableLiveData()

    fun getProductViewModel(){
        viewModelScope.launch {
            pList.value = repository.doNetworkCal()
        }
    }
}