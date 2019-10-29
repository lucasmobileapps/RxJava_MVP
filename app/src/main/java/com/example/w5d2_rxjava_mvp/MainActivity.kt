package com.example.w5d2_rxjava_mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.w5d2_rxjava_mvp.model.RepoResponse
import com.example.w5d2_rxjava_mvp.presenter.GitRepositoryPresenter
import com.example.w5d2_rxjava_mvp.presenter.PresenterContract
import com.example.w5d2_rxjava_mvp.util.ApplicationData
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), PresenterContract.GitRepoView {
    override fun callFailed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    lateinit var gitRepositoryPresenter: PresenterContract.GitRepoPresenter

    val compositeDisposable= CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApplicationData.daggerPresenterComponent?.inject(this)
        gitRepositoryPresenter.setRepoView(this)


        //prevents memory leaks
        compositeDisposable.add(
            gitRepositoryPresenter.getRepositories().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ myList ->
                    printMyList(myList)
                }, {throwage ->
                    //TODO: Error Logger
                })
        )
    }

    private fun printMyList(list: List<RepoResponse>){
        Log.d("LOG_X", "Print called ${list.size}")

        val stringBuilder = StringBuilder()
        list.forEach{ item ->
            stringBuilder.append("${item.name}\n")
        }
        my_textview.text = stringBuilder
    }

    override fun onResume() {
        super.onResume()
    }
}
