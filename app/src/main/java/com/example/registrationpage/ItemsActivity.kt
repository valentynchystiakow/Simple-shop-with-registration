// imports package
package com.example.registrationpage

// imports libraries
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

// creates items activity class that runs items layout
class ItemsActivity : AppCompatActivity() {
    // overrides main abstract function that creates state instance of layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        // creates items list that inherits from recycler view class
        val itemsList: RecyclerView = findViewById(R.id.list_items)
        val items = arrayListOf<Item>()
        // adds items to array of items
        items.add(Item(1, "sofa", "Sofa", " Sofa for your home", "Europe quality", 100))
        items.add(Item(2, "light", "Light", "Bright light for your room", "American quality", 100))
        items.add(Item(3, "kitchen", "Kitchen", "Kitchen for your home", "Italian quality", 100))
        // creates instance of items adapter, this means that items list will show items, adapter is used to connect items list with items
        itemsList.adapter = ItemsAdapter(items, this)
        // creates layoutManager for items list, layout manager is used to determine how items list will be displayed
        itemsList.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
    }
}