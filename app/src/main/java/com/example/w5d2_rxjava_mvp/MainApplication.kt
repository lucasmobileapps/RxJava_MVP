package com.example.w5d2_rxjava_mvp

import android.app.Application
import android.util.Log
import com.example.w5d2_rxjava_mvp.di.DaggerGitComponent
import com.example.w5d2_rxjava_mvp.di.DaggerPresenterComponent
import com.example.w5d2_rxjava_mvp.util.ApplicationData

class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        ApplicationData.daggerGitComponent = DaggerGitComponent.create()
        ApplicationData.daggerPresenterComponent = DaggerPresenterComponent.create()
        Log.d("LOG_X", "Singleton assigned!")
    }
}