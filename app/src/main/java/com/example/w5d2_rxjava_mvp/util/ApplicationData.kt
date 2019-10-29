package com.example.w5d2_rxjava_mvp.util

import com.example.w5d2_rxjava_mvp.di.DaggerGitComponent
import com.example.w5d2_rxjava_mvp.di.GitComponent
import com.example.w5d2_rxjava_mvp.di.PresenterComponent

object ApplicationData {

    var daggerGitComponent: GitComponent? = null
    var daggerPresenterComponent: PresenterComponent? = null

}