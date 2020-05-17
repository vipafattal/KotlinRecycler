package com.abed.kotlin_recycler.baseComponent

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<Data : Any>(
    protected var dataList: List<Data>,
    private val onClickListener: (View.(Int) -> Unit)?
) : RecyclerView.Adapter<BaseViewHolder>() {
    private lateinit var mRecyclerView: RecyclerView
    abstract val layoutItemId: Int
    override fun getItemCount(): Int = dataList.size
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        val baseViewHolder = BaseViewHolder(
            parent,
            layoutItemId
        )

        if (onClickListener != null)
            baseViewHolder.itemView.setOnClickListener(onItemClickListener)

        return baseViewHolder
    }

    internal val onItemClickListener = object :
        OnItemClickListener {
        override fun onClick(v: View?) {
            val position = mRecyclerView.layoutManager!!.getPosition(v!!)
            onItemClick(v, position)
        }

        override fun onItemClick(v: View, position: Int) {
            onClickListener!!.invoke(v,position)
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }
}