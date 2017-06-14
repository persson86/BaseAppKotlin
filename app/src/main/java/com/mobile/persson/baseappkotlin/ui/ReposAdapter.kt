package com.mobile.persson.baseappkotlin.ui

import android.view.View
import android.widget.TextView
import com.mobile.persson.baseappkotlin.R
import com.mobile.persson.baseappkotlin.base.BaseAdapter
import com.mobile.persson.baseappkotlin.base.BaseViewHolder
import com.mobile.persson.baseappkotlin.model.TagItemModel

class ReposAdapter : BaseAdapter<TagItemModel, ReposAdapter.ReposViewHolder>() {

    override fun getItemViewId(): Int = R.layout.view_item

    override fun instantiateViewHolder(view: View?): ReposViewHolder = ReposViewHolder(view)

    class ReposViewHolder(itemView: View?) : BaseViewHolder<TagItemModel>(itemView) {

        val tvName : TextView by lazy { itemView?.findViewById(R.id.tvName) as TextView }

        override fun onBind(item: TagItemModel) {
            tvName.text = item.name
        }

    }

}