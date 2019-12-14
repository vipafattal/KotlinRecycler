package com.abed.kotlin_recycler.baseComponent

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class BaseRecyclerAdapter<Data : Any>(
    protected var dataList: List<Data>
) : RecyclerView.Adapter<BaseViewHolder>() {

    abstract val layoutItemId: Int

    override fun getItemCount(): Int = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        BaseViewHolder(
            parent,
            layoutItemId
        )
}