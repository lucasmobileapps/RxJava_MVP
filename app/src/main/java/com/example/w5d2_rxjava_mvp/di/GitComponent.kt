package com.example.w5d2_rxjava_mvp.di

import com.example.w5d2_rxjava_mvp.di.module.GitModule
import com.example.w5d2_rxjava_mvp.presenter.GitRepositoryPresenter
import com.example.w5d2_rxjava_mvp.presenter.GitUserPresenter
import dagger.Component

@Component(modules = [GitModule::class])
interface GitComponent {
    fun inject(gitRepoPresenter: GitRepositoryPresenter)
    fun inject(gitUserPresenter: GitUserPresenter)
}