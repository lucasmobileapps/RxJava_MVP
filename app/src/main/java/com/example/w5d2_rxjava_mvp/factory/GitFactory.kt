package com.example.w5d2_rxjava_mvp.factory

import com.example.w5d2_rxjava_mvp.model.RepoResponse
import com.example.w5d2_rxjava_mvp.model.UserResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class GitFactory {
    val BASE_URL = "https://api.github.com/"
    var gitFactoryService: GetGitService

    init{
        gitFactoryService = createService(getRetrofitInstance())
    }

    private fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    private fun createService(retrofit: Retrofit): GetGitService{
        return retrofit.create(GetGitService::class.java)
    }

    fun getGitUser(userName: String): Observable<UserResponse>{
        return gitFactoryService.getGitUse(userName)
    }

    fun getGitRepositories(userName: String): Observable<List<RepoResponse>>{
        return gitFactoryService.getUserRepos(userName)
    }
}