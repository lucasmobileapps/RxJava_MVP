package com.example.w5d2_rxjava_mvp.presenter

import com.example.w5d2_rxjava_mvp.factory.GitFactory
import com.example.w5d2_rxjava_mvp.model.RepoResponse
import com.example.w5d2_rxjava_mvp.util.ApplicationData
import io.reactivex.Observable
import javax.inject.Inject

class GitRepositoryPresenter : PresenterContract.GitRepoPresenter{

    @Inject
    lateinit var gitFactory: GitFactory

    init {
        ApplicationData.daggerGitComponent?.inject(this)
    }

    private lateinit var repoView: PresenterContract.GitRepoView

    override fun getRepositories(): Observable<List<RepoResponse>> {
        return gitFactory.getGitRepositories("lucasmobileapps")
    }

    override fun setRepoView(repoView: PresenterContract.GitRepoView) {

        this.repoView = repoView

    }
}