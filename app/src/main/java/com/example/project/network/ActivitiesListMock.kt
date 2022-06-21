package com.example.project.network

import com.example.project.model.ActivityModel

object ActivitiesListMock {
    fun getActivitiesList(): List<ActivityModel> {
        return listOf(
            ActivityModel("education"),
            ActivityModel("recreational"),
            ActivityModel("social"),
            ActivityModel("diy"),
            ActivityModel("charity"),
            ActivityModel("cooking"),
            ActivityModel("relaxation"),
            ActivityModel("music"),
            ActivityModel("charity"),
            ActivityModel("busywork"),
        )
    }

}