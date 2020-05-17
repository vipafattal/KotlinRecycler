package com.abed.binding_recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.abed.binding_recycler.BaseBindingViewHolder
import com.abed.binding_recycler.OnBindingItemClick
import com.abed.binding_recycler.OnBindingItemLongClick

class BindingRecyclerAdapter<Data : Any>(
    var dataList: List<Data>,
    @LayoutRes
    private val layoutId: Int,
    private val bindingVariable: Int,
    private val onItemClick: OnBindingItemClick? = null,
    private val onItemLongClick: OnBindingItemLongClick? = null
) : RecyclerView.Adapter<BaseBindingViewHolder<Data>>() {



    override fun getItemCount(): Int = dataList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseBindingViewHolder<Data> {

        val inflater = LayoutInflater.from(parent.context)

        val viewBinding =
            DataBindingUtil.inflate<ViewDataBinding>(inflater, layoutId, parent, false)

        return BaseBindingViewHolder(
            bindingVariable,
            viewBinding
        )
    }

    override fun onBindViewHolder(holder: BaseBindingViewHolder<Data>, position: Int) {
        holder.bindData(dataList[position],onItemClick,onItemLongClick)
    }
}