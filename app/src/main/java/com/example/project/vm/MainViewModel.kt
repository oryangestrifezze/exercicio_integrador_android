package com.example.project.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _isvalid: MutableLiveData<Boolean> = MutableLiveData()

    val isValid: LiveData<Boolean>
        get() = _isvalid


    fun start(participants: String){
        _isvalid.value = participants.isNotEmpty() && participants != "0"
    }
}

