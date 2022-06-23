package com.example.project

import android.app.Application

class PreferencesApplication : Application() {

    companion object {
    lateinit var preferences: Preferences
    }
    override fun onCreate() {
        super.onCreate()
        preferences = Preferences(applicationContext)
    }
}