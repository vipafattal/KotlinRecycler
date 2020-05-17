package com.abed.binding_recycler

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by ${User} on ${Date}
 */
class BaseBindingViewHolder<in Item : Any>(
    private val bindingVariable: Int,
    private val binding: ViewDataBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(
        data: Item,
        onItemClick: OnBindingItemClick?,
        onItemLongClick: OnBindingItemLongClick?
    ) {

         if (onItemClick != null)
            binding.setVariable(onItemClick.variableName, onItemClick)

        if (onItemLongClick != null)
            binding.setVariable(onItemLongClick.variableName, onItemLongClick)

        binding.setVariable(bindingVariable, data)
        binding.executePendingBindings()
    }

    fun clearAnimation() = itemView.clearAnimation()

}