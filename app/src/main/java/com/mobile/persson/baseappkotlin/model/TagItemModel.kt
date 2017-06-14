package com.mobile.persson.baseappkotlin.model

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


data class TagItemModel(val name: String? = null) {
    
    class ListDeserializer : ResponseDeserializable<List<TagItemModel>> {
        override fun deserialize(content: String) =
                Gson().fromJson<List<TagItemModel>>(content, object : TypeToken<List<TagItemModel>>() {}.type)
    }
}