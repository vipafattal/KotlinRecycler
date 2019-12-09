[![](https://jitpack.io/v/vipafattal/KotlinRecycler.svg)](https://jitpack.io/#vipafattal/KotlinRecycler)
(http://www.apache.org/licenses/LICENSE-2.0)

# KotlinRecycler
Simple RecyclerView Adapter using Kotlin


### ReyclerView made simple as one line of code
```xml
recyclerView.withSimpleAdapter(dummyData, R.layout.item_recipe) { data ->
  itemView.recipe_img.setImageResource(data.drawable)
  itemView.recipe_name.text = data.name
}
```
# Usage

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
implementation 'com.github.vipafattal:KotlinRecycler:1.0'
```

#### Example :
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
##### to handle clicks on items you have two options:

1.now all you need is to call withSimpleAdapter() function on recyclerView as below:

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


        recyclerView.withSimpleAdapter(dummyData, R.layout.item_recipe) { data ->
            itemView.recipe_img.setImageResource(data.drawable)
            itemView.recipe_name.text = data.name
        }
    }
}
```

##### you're free to make pull request and contribute, happy coding!

