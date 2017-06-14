package com.mobile.persson.baseappkotlin.sources.repos

import com.mobile.persson.baseappkotlin.model.TagItemModel
import io.reactivex.Single

interface ReposDataSource {

    fun getTags(): Single<List<TagItemModel>>

    fun saveTags(list: List<TagItemModel>) : Unit = Unit
}
