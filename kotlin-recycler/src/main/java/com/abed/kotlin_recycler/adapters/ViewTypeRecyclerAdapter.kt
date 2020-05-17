package com.abed.kotlin_recycler.adapters

import android.view.View
import android.view.ViewGroup
import com.abed.kotlin_recycler.baseComponent.BaseViewHolder

class ViewTypeRecyclerAdapter<RecyclerData : Any>(
    data: List<RecyclerData>,
    animationRes: Int,
    onBindView: BaseViewHolder.(data: RecyclerData) -> Unit,
    private val viewTypeLayout: (position: Int) -> Int,
    private val onClickListener: (View.(Int) -> Unit)?
) : SimpleRecyclerAdapter<RecyclerData>(data, 0, animationRes, onBindView,onClickListener) {

    override fun getItemViewType(position: Int): Int = viewTypeLayout(position)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val baseViewHolder = BaseViewHolder(parent, viewType)
        if (onClickListener != null)
            baseViewHolder.itemView.setOnClickListener(onItemClickListener)
        return baseViewHolder
    }
}

