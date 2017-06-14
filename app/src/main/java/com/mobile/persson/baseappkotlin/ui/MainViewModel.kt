package com.mobile.persson.baseappkotlin.ui

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import com.mobile.persson.baseappkotlin.model.TagItemModel
import com.mobile.persson.baseappkotlin.sources.repos.ReposRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val reposRepository = ReposRepository()

    private val organizationLiveData = MutableLiveData<String>()

    val resultLiveData = ReposLiveData(reposRepository)
    init {
        resultLiveData.addSource(organizationLiveData) {
            it?.let { resultLiveData.organization = it }
        }
    }

    val isLoadingLiveData = MediatorLiveData<Boolean>()
    init {
        isLoadingLiveData.addSource(resultLiveData) {
            isLoadingLiveData.value = false
        }
    }

    val throwableLiveData = MediatorLiveData<Throwable>()
    init {
        throwableLiveData.addSource(resultLiveData) {
            it?.second?.let { throwableLiveData.value = it }
        }
    }

    val reposLiveData = MediatorLiveData<List<TagItemModel>>()
    init {
        reposLiveData.addSource(resultLiveData) {
            it?.first?.let { reposLiveData.value = it }
        }
    }

    fun setOrganization(organization: String) {
        organizationLiveData.value = organization
        isLoadingLiveData.value = true
    }
}