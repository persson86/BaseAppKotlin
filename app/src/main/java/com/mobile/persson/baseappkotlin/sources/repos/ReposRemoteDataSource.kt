package com.mobile.persson.baseappkotlin.sources.repos

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.rx.rx_object
import com.ik.exploringviewmodel.log
import com.mobile.persson.baseappkotlin.model.TagItemModel
import io.reactivex.Single

class ReposRemoteDataSource : ReposDataSource {

    init {
        FuelManager.instance.basePath = "https://api.github.com"
    }

    override fun getTags(): Single<List<TagItemModel>> =
            "/orgs/yalantis/repos"
                    .httpGet()
                    .log()
                    .rx_object(TagItemModel.ListDeserializer())
                    .map { it?.component1() ?: throw it?.component2() ?: throw Exception() }

}