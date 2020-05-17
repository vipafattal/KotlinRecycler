package com.abed.kotlin_recycler

import android.view.View
import androidx.annotation.AnimRes
import androidx.recyclerview.widget.RecyclerView
import com.abed.kotlin_recycler.adapters.SimpleRecyclerAdapter
import com.abed.kotlin_recycler.adapters.ViewTypeRecyclerAdapter
import com.abed.kotlin_recycler.baseComponent.BaseViewHolder

fun <T : Any> RecyclerView.withViewTypeAdapter(
    dataList: List<T>, @AnimRes turnUpAnim: Int, viewType: (Int) -> Int,
    onBindView: BaseViewHolder.(data: T) -> Unit,
    onClickListener: (View.(Int) -> Unit)?
): ViewTypeRecyclerAdapter<T> = ViewTypeRecyclerAdapter(
    dataList,
    turnUpAnim,
    onBindView,
    viewType,
    onClickListener
)

fun <T : Any> RecyclerView.withViewTypeAdapter(
    dataList: List<T>, @AnimRes turnUpAnim: Int, viewType: (Int) -> Int,
    onBindView: BaseViewHolder.(data: T) -> Unit
): ViewTypeRecyclerAdapter<T> = ViewTypeRecyclerAdapter(
    dataList,
    turnUpAnim,
    onBindView,
    viewType,
    null)

fun <T : Any> RecyclerView.withViewTypeAdapter(
    dataList: List<T>, viewType: (Int) -> Int,
    onBindView: BaseViewHolder.(data: T) -> Unit,
    onClickListener: (View?.(Int) -> Unit)?
): ViewTypeRecyclerAdapter<T> {
    val recyclerAdapter =
        ViewTypeRecyclerAdapter(
            dataList,
            SimpleRecyclerAdapter.NO_TURN_UP_ANIMATION,
            onBindView, viewType,
            onClickListener
        )
    adapter = recyclerAdapter
    return recyclerAdapter
}

fun <T : Any> RecyclerView.withViewTypeAdapter(
    dataList: List<T>, viewType: (Int) -> Int,
    onBindView: BaseViewHolder.(data: T) -> Unit
): ViewTypeRecyclerAdapter<T> {
    val recyclerAdapter =
        ViewTypeRecyclerAdapter(
            dataList,
            SimpleRecyclerAdapter.NO_TURN_UP_ANIMATION,
            onBindView, viewType,
            null
        )
    adapter = recyclerAdapter
    return recyclerAdapter
}