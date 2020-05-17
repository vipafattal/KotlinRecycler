package com.abed.binding_recycler

import android.view.View

interface OnBindingItemLongClick : View.OnLongClickListener {
    val variableName: Int
}