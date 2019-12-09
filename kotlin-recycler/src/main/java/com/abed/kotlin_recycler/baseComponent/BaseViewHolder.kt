package com.abed.kotlin_recycler.baseComponent

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.abed.kotlin_recycler.helpers.inflater

/**
 * Created by ${User} on ${Date}
 */
open class BaseViewHolder<T>(parent: ViewGroup, @LayoutRes layoutId: Int) :
    RecyclerView.ViewHolder(parent.inflater(layoutId)) {

    fun clearAnimation() = itemView.clearAnimation()

}