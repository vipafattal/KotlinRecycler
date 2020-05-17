package com.abed.binding_recycler

import android.view.View

interface OnBindingItemClick : View.OnClickListener{
    val variableName: Int
    fun onItemClick(v:View?,position:Int)
}