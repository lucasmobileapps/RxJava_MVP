package com.example.w5d2_rxjava_mvp.di

import com.example.w5d2_rxjava_mvp.MainActivity
import com.example.w5d2_rxjava_mvp.di.module.PresenterModule
import dagger.Component

@Component(modules = [PresenterModule::class])
interface PresenterComponent {
    fun inject(mainActivity: MainActivity)
    //TODO :fragment
}