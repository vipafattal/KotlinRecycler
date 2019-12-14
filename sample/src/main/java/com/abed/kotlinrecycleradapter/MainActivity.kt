package com.abed.kotlinrecycleradapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abed.kotlin_recycler.withSimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_recipe.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dummyData = listOf(
            Recipe("Chocolate", R.drawable.a),
            Recipe("French Fries", R.drawable.b),
            Recipe("milkshake", R.drawable.c),
            Recipe("Mushroom soup", R.drawable.g),
            Recipe("Cool juice", R.drawable.f),
            Recipe("Cool Watermelon drink", R.drawable.h)
        )


        recyclerView.withSimpleAdapter(dummyData, R.layout.item_recipe) { data ->
            recipe_img.setImageResource(data.drawable)
            recipe_name.text = data.name
        }
    }
}
