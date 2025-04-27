// imports packages
package com.example.registrationpage
// imports libraries
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


// creates class that inherits from AppCompatActivity
class ItemActivity : AppCompatActivity() {
    // overrides abstract superclass method that creates instance of layout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        // creates variables for layout elements(widgets)
        val title: TextView = findViewById(R.id.item_list_title_one)
        val text: TextView = findViewById(R.id.item_list_text)
        val image: ImageView = findViewById(R.id.item_list_image_one)
        val imageId: Int = intent.getIntExtra("itemImageId", 0)
        // gets values from intent and displays them
        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        image.setImageResource(imageId)


    }
}