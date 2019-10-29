package com.example.w5d2_rxjava_mvp.di.module

import com.example.w5d2_rxjava_mvp.factory.GitFactory
import dagger.Module
import dagger.Provides

@Module
class GitModule {

    @Provides
    fun providesGitFactory(): GitFactory{
        return  GitFactory()
    }
}