package com.abed.kotlin_recycler.baseComponent

import android.view.View

interface OnItemClickListener : View.OnClickListener{
    fun onItemClick(v:View,position:Int)
}