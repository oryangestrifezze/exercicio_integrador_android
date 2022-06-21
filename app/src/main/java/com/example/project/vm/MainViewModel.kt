package com.example.project.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project.ActivitiesListActivity
import com.example.project.model.ActivityModel
import com.example.project.network.ActivitiesListMock

class MainViewModel : ViewModel() {
    private var _isvalid: MutableLiveData<Boolean> = MutableLiveData()


    private var _activities: MutableLiveData<List<ActivityModel>> = MutableLiveData()



    val isValid: LiveData<Boolean>
        get() = _isvalid

    val activities: LiveData<List<ActivityModel>>
        get() = _activities


    fun start(participants: String){
        _isvalid.value = participants.isNotEmpty() && participants != "0"
    }

    fun fetchActivities(){
        val result = ActivitiesListMock.getActivitiesList()
        _activities.value = result
    }
}

