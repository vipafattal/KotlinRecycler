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
class BaseViewHolder(
    parent: ViewGroup,
    @LayoutRes layoutId: Int
) : RecyclerView.ViewHolder(parent.inflater(layoutId)), LayoutContainer {

    override val containerView: View = itemView
    val context = itemView.context

    fun clearAnimation() = containerView.clearAnimation()

    /**
     * This will create object every time user onBindViewHolder,
     * if you to avoid object creating pass click function with adapter creation see sample app for example.
     *
     **/
    inline fun onItemClickListener(crossinline block: (Int) -> Unit) {
        itemView.setOnClickListener {
            block(adapterPosition)
        }
    }

}