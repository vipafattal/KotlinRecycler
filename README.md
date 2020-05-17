[![](https://jitpack.io/v/vipafattal/KotlinRecycler.svg)](https://jitpack.io/#vipafattal/KotlinRecycler)
(http://www.apache.org/licenses/LICENSE-2.0)

# KotlinRecycler
Simple RecyclerView Adapter using Kotlin


### ReyclerView made simple as one line of code
```kotlin
recyclerView.withSimpleAdapter(dummyData, R.layout.item_recipe) { data ->
  itemView.recipe_img.setImageResource(data.drawable)
  itemView.recipe_name.text = data.name
}
```
# Setup

#### Step 1
add in your root build.gradle at the end of repositories
```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
#### Step 2
add the dependency to the app module
```groovy
implementation 'com.github.vipafattal:KotlinRecycler:1.2.1'
```

#### Step 3
add this line to the app module to enable view extensions in RecyclrView Holder
```
androidExtensions {
   experimental = true
}
```
### for more info about the implementation see [see this atricle](https://medium.com/p/1e6ab9a55fe7)


# Example :
```xml
      <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        tools:itemCount="3"
        tools:listitem="@layout/item_recipe" />
```

1.now all you need is to call withSimpleAdapter() function on recyclerView then you could call anything from the holder like itemView as shown below:

```kotlin
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

        //Without item clickListener.
        recyclerView.withSimpleAdapter(dummyData, R.layout.item_recipe) { data ->
            itemView.recipe_img.setImageResource(data.drawable)
            itemView.recipe_name.text = data.name
        }

        //Set onItemClickListener (Avoid object creation each time view onBindViewHolderCalled).
        recyclerView.withSimpleAdapter(dummyData, R.layout.item_recipe,
            onBindView = { data ->
                recipe_img.setImageResource(data.drawable)
                recipe_name.text = data.name
            }, 
	    onItemClick = { position ->
                Toast.makeText(context, dummyData[position].name, Toast.LENGTH_LONG).show()
            }
        )
	
	//OR

        recyclerView.withSimpleAdapter(dummyData, R.layout.item_recipe) { data ->
            itemView.recipe_img.setImageResource(data.drawable)
            itemView.recipe_name.text = data.name
            //set onItemClickListener each time view get binned to recyclerView (Each time create onClickListener object)
	    onItemClickListener { position->          
	       Toast.makeText(context, dummyData[position].name, Toast.LENGTH_LONG).show()
	    }
        }
    }
}
```
##### you're free to make pull request and contribute, happy coding!

