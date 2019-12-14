package com.abed.kotlin_recycler.baseComponent

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.abed.kotlin_recycler.helpers.inflater
import kotlinx.android.extensions.LayoutContainer

/**
 * Created by ${User} on ${Date}
 */
class BaseViewHolder(parent: ViewGroup, @LayoutRes layoutId: Int) :
    RecyclerView.ViewHolder(parent.inflater(layoutId)), LayoutContainer {

    override val containerView: View
        get() = itemView

    fun clearAnimation() = containerView.clearAnimation()

}