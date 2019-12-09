package com.abed.kotlin_recycler.adapters

import android.view.View
import android.view.animation.AnimationUtils
import androidx.annotation.LayoutRes
import com.abed.kotlin_recycler.baseComponent.BaseRecyclerAdapter
import com.abed.kotlin_recycler.baseComponent.BaseViewHolder


class SimpleRecyclerAdapter<RecyclerData : Any>(
    data: List<RecyclerData>, @LayoutRes layoutID: Int,
    private val animationRes: Int,
    private val onBindView: BaseViewHolder<RecyclerData>.(data: RecyclerData) -> Unit
) : BaseRecyclerAdapter<RecyclerData>(data) {

    override val layoutItemId: Int = layoutID

    

    override fun onBindViewHolder(holder: BaseViewHolder<RecyclerData>, position: Int) {
        val data = dataList[position]

        holder.onBindView(data)

        if (animationRes != NO_TURN_UP_ANIMATION)
            holder.itemView.setAnimation(position)
    }

    private var lastPosition = -1
    private fun View.setAnimation(position: Int) {

        if (position > lastPosition) {
            val animation =
                AnimationUtils.loadAnimation(context, animationRes)

            startAnimation(animation)
            lastPosition = position
        }
    }

    override fun onViewDetachedFromWindow(holder: BaseViewHolder<RecyclerData>) {
        holder.clearAnimation()
    }

    companion object {
        const val NO_TURN_UP_ANIMATION = -1
    }
}
