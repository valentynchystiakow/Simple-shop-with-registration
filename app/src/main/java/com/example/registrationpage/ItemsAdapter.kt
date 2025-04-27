// imports package
package com.example.registrationpage

//imports packages
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// creates class ItemsAdapter that inherits from RecyclerView.Adapter
class ItemsAdapter(var items: List<Item>, var context: Context) :
    RecyclerView.Adapter<ItemsAdapter.MyViewFolder>() {

    //    creates class MyViewFolder that inherits from RecyclerView.ViewHolder
    class MyViewFolder(view: View) : RecyclerView.ViewHolder(view) {
        // creates values for storing views widgets
        val image: ImageView = view.findViewById(R.id.item_list_image)
        val title: TextView = view.findViewById(R.id.item_list_title)
        val description: TextView = view.findViewById(R.id.item_list_description)
        val price: TextView = view.findViewById(R.id.item_list_price)
        val btn: Button = view.findViewById(R.id.item_list_button)
    }

    //    overrides abstract superclass method that creates view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewFolder {
        //    creates instance of LayoutInflater for inflating layout file and returns it
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list, parent, false)
        return MyViewFolder(view)
    }

    // overrides abstract superclass method that returns items count
    override fun getItemCount(): Int {
        return items.count()
    }

    // overrides abstract superclass method that binds view holder
    override fun onBindViewHolder(holder: MyViewFolder, position: Int) {
        // gets image id from drawable folder
        val imageId =
            context.resources.getIdentifier(
                items[position].image,
                "drawable",
                context.packageName
            )
        holder.image.setImageResource(imageId)
        holder.title.text = items[position].title
        holder.description.text = items[position].desc
        holder.price.text = items[position].price.toString() + "$"
        // creates action listener for look button
        holder.btn.setOnClickListener {
            // Intent - class that allows you to move from one activity to another(from Items Activity to Item Activity)
            val intent = Intent(context, ItemActivity::class.java)
            // putExtra - method that allows you to pass data from one activity to another
            intent.putExtra("itemTitle", items[position].title)
            intent.putExtra("itemText", items[position].text)
            intent.putExtra("itemImageId", imageId)
            context.startActivity(intent)
        }

    }
}