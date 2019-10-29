package com.example.w5d2_rxjava_mvp.presenter

import com.example.w5d2_rxjava_mvp.factory.GitFactory
import com.example.w5d2_rxjava_mvp.model.RepoResponse
import com.example.w5d2_rxjava_mvp.model.UserResponse
import com.example.w5d2_rxjava_mvp.util.ApplicationData
import io.reactivex.Observable
import javax.inject.Inject

class GitUserPresenter : PresenterContract.GitUserPresenter {

    @Inject
    lateinit var gitFactory: GitFactory
    private lateinit var userView: PresenterContract.GitUserView

    override fun setUserView(userView: PresenterContract.GitUserView) {
        this.userView = userView
    }

    init {
        ApplicationData.daggerGitComponent?.inject(this)
    }

    override fun getUser(): Observable<UserResponse> {
        return gitFactory.getGitUser("lucasmobileapps")
    }
}