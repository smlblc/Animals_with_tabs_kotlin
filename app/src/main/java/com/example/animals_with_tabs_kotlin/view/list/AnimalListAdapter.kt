package com.example.animals_with_tabs_kotlin.view.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.animals_with_tabs_kotlin.R
import com.example.animals_with_tabs_kotlin.data.Animal
import kotlinx.android.synthetic.main.item_list_animal.view.*

class AnimalListAdapter(val animals: MutableList<Animal>, var itemViewClickListener: ItemViewClickListener? = null ) :
    RecyclerView.Adapter<AnimalListAdapter.PersonViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_animal, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.textView.text = animals.get(position).name
        holder.imageView.setImageResource(animals.get(position).imageId)
        holder.itemView.setOnClickListener { itemViewClickListener?.onItemClick(position) }
        Log.d("MyApp", "Binding the ViewHolder on Position: $position")
    }

    override fun getItemCount(): Int {
        return animals.size
    }

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView : TextView = itemView.findViewById<TextView>(R.id.text_animal_name)
        var imageView : ImageView = itemView.findViewById<ImageView>(R.id.image_animal)

        init {
            itemView.setOnClickListener { View.OnClickListener {
                    fun onClick(view: View) {
                        Toast.makeText(
                            view.context,
                            "Position: " + adapterPosition + "clicked.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

    }
}

interface ItemViewClickListener {
    fun onItemClick(position: Int)
}
