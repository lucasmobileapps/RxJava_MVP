package com.example.w5d2_rxjava_mvp.di.module

import com.example.w5d2_rxjava_mvp.presenter.GitRepositoryPresenter
import com.example.w5d2_rxjava_mvp.presenter.GitUserPresenter
import com.example.w5d2_rxjava_mvp.presenter.PresenterContract
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun providesGitRepoPresenter():PresenterContract.GitRepoPresenter{
        return GitRepositoryPresenter()
    }
    @Provides
    fun providesGitUserPresenter():PresenterContract.GitUserPresenter{
        return GitUserPresenter()
    }
}