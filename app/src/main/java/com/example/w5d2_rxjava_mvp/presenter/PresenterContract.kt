package com.example.w5d2_rxjava_mvp.presenter

import com.example.w5d2_rxjava_mvp.model.RepoResponse
import com.example.w5d2_rxjava_mvp.model.UserResponse
import io.reactivex.Observable

interface PresenterContract {
    interface GitRepoPresenter {
        fun getRepositories(): Observable<List<RepoResponse>>
        fun setRepoView(repoView: GitRepoView)
    }
    interface GitUserPresenter{
        fun getUser(): Observable<UserResponse>
        fun setUserView(userView: GitUserView)
    }
    interface GitRepoView{
        fun callFailed()
    }
    interface GitUserView{
        fun callFailed()
    }
}