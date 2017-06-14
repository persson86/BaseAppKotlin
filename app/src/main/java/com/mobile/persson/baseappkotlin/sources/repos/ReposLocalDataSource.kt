package com.mobile.persson.baseappkotlin.sources.repos

import com.mobile.persson.baseappkotlin.model.TagItemModel
import io.reactivex.Single

class ReposLocalDataSource : ReposDataSource {

    override fun saveTags(list: List<TagItemModel>) {}

    override fun getTags(): Single<List<TagItemModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}