package com.abed.kotlin_recycler.helpers

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

internal fun ViewGroup.inflater(layoutRes: Int): View =
    LayoutInflater.from(context).inflate(layoutRes, this, false)