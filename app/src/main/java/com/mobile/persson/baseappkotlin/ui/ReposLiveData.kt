package com.mobile.persson.baseappkotlin.ui

import android.arch.lifecycle.MediatorLiveData
import android.util.Pair
import com.mobile.persson.baseappkotlin.model.TagItemModel
import com.mobile.persson.baseappkotlin.sources.repos.ReposRepository
import io.reactivex.disposables.Disposable

class ReposLiveData(val repository: ReposRepository)
    : MediatorLiveData<Pair<List<TagItemModel>?, Throwable?>>() {

    private var disposable: Disposable? = null

    var organization: String? = null
        set(value) {
            value?.let {
                disposable = repository
                        .getTags()
                        .subscribe { data, error -> this@ReposLiveData.value = Pair(data, error) }

            }
        }

    override fun onInactive() {
        super.onInactive()
        if (disposable?.isDisposed?.not() ?: false) {
            disposable?.dispose()
        }
    }

}