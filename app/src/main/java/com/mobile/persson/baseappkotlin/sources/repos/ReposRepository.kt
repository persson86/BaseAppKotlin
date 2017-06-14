package com.mobile.persson.baseappkotlin.sources.repos

import android.arch.lifecycle.LiveData
import android.util.Log
import com.mobile.persson.baseappkotlin.model.TagItemModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ReposRepository() : ReposDataSource {

    private val localDataSource = ReposLocalDataSource()
    private val remoteDataSource = ReposRemoteDataSource()

    override fun getTags(): Single<List<TagItemModel>>
            = remoteDataSource.getTags()
            .doOnSuccess { Log.v("LFSP", "SUCESSO") }
            .doOnError { Log.v("LFSP", "ERORR") }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}
