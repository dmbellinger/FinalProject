package com.hfad.finalproject

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DeleteAdapter(viewModel: ItemsViewModel): RecyclerView.Adapter<DeleteAdapter.ViewHolder>() {
    val viewModel = viewModel
    val items: List<Item> = viewModel.getItems()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = items[position]


        // sets the text to the textview from our itemHolder class
        holder.nameDisplay.text = ItemsViewModel.name
        holder.priceDisplay.text = ItemsViewModel.price.toString()
        holder.categoryDisplay.text = ItemsViewModel.category.toString()
        holder.quantityDisplay.text = ItemsViewModel.quantity.toString()


    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val nameDisplay: TextView = itemView.findViewById(R.id.nameDisplay)
        val priceDisplay: TextView = itemView.findViewById(R.id.priceDisplay)
        val categoryDisplay: TextView = itemView.findViewById(R.id.CategoryDisplay)
        val quantityDisplay: TextView = itemView.findViewById(R.id.QuantityDisplay)

    }
}