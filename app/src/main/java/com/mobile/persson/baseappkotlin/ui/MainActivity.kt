package com.mobile.persson.baseappkotlin.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import com.mobile.persson.baseappkotlin.R
import com.mobile.persson.baseappkotlin.base.BaseLifecycleActivity
import com.mobile.persson.baseappkotlin.model.TagItemModel

class MainActivity : BaseLifecycleActivity<MainViewModel>() {

    override val viewModelClass = MainViewModel::class.java
    private val tags by lazy { findViewById(R.id.tags) as RecyclerView }

    private val adapter = ReposAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tags.setHasFixedSize(true)
        tags.adapter = adapter

        if (savedInstanceState == null) {
            viewModel.setOrganization("yalantis")
        }

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.reposLiveData.observe(this, Observer<List<TagItemModel>> {
            it?.let { adapter.dataSource = it }
        })
        viewModel.throwableLiveData.observe(this, Observer<Throwable> {
            it?.let { Snackbar.make(tags, it.localizedMessage, Snackbar.LENGTH_LONG).show() }
        })
    }
}
