package com.example.w5d2_rxjava_mvp.factory

import com.example.w5d2_rxjava_mvp.model.RepoResponse
import com.example.w5d2_rxjava_mvp.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GetGitService {
    @GET("users/{user_name}")
    fun getGitUse(@Path("user_name") gitUserName: String): Observable<UserResponse>

    @GET("users/{user_name}/repos")
    fun getUserRepos(@Path("user_name") getUserRepos: String): Observable<List<RepoResponse>>
}