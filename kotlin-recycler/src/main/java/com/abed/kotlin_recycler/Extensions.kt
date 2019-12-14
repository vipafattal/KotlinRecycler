package com.abed.kotlin_recycler

import androidx.annotation.AnimRes
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.abed.kotlin_recycler.adapters.SimpleRecyclerAdapter
import com.abed.kotlin_recycler.baseComponent.BaseViewHolder


fun <T : Any> RecyclerView.withSimpleAdapter(
    dataList: List<T>, @LayoutRes layoutID: Int, @AnimRes turnUpAnim: Int,
    onBindView: BaseViewHolder.(data: T) -> Unit
): SimpleRecyclerAdapter<T> {
    val recyclerAdapter =
        SimpleRecyclerAdapter(
            dataList,
            layoutID,
            turnUpAnim,
            onBindView
        )
    adapter = recyclerAdapter
    return recyclerAdapter
}

fun <T : Any> RecyclerView.withSimpleAdapter(
    dataList: List<T>, @LayoutRes layoutID: Int,
    onBindView: BaseViewHolder.(data: T) -> Unit
): SimpleRecyclerAdapter<T> {
    val recyclerAdapter =
        SimpleRecyclerAdapter(
            dataList,
            layoutID,
            SimpleRecyclerAdapter.NO_TURN_UP_ANIMATION,
            onBindView
        )
    adapter = recyclerAdapter
    return recyclerAdapter
}


