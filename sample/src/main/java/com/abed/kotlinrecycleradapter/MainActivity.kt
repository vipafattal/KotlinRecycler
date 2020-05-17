package com.abed.kotlinrecycleradapter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.abed.kotlin_recycler.withSimpleAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_recipe.*

class MainActivity : AppCompatActivity() {
    //private lateinit var activityMainBinding: ActivityMainBinding
    val dummyData = listOf(
        Recipe("Chocolate", R.drawable.a),
        Recipe("French Fries", R.drawable.b),
        Recipe("milkshake", R.drawable.c),
        Recipe("Mushroom soup", R.drawable.g),
        Recipe("Cool juice", R.drawable.f),
        Recipe("Cool Play play Watermelon drink", R.drawable.h)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //To set onItemClickListener (avoid object creation each time view onBindViewHolderCalled).
        recyclerView.withSimpleAdapter(dummyData, R.layout.item_recipe,
            onBindView = { data ->
                recipe_img.setImageResource(data.drawable)
                recipe_name.text = data.name
            },
            onItemClick = { position ->
                Toast.makeText(context, dummyData[position].name, Toast.LENGTH_LONG).show()
            }
        )

        recyclerView.withSimpleAdapter(dummyData, R.layout.item_recipe) { data ->
            recipe_img.setImageResource(data.drawable)
            recipe_name.text = data.name
            //set onItemClickListener each time view get binned to recyclerView (Each time create onClickListener object)
            onItemClickListener { position ->
                Toast.makeText(context, dummyData[position].name, Toast.LENGTH_LONG).show()
            }
        }
    }
}
