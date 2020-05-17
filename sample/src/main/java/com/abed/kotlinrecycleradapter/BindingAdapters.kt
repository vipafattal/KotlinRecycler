package com.abed.kotlinrecycleradapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("binding:src")
fun setImageResource(imageView: ImageView, src: Int) {
    Glide.with(imageView.context).load(src).into(imageView)
}

