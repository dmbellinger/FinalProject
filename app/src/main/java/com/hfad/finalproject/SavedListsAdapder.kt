package com.hfad.finalproject

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class SavedListsAdapter(private val savedLists: List<SavedListPlaceholder>) : RecyclerView.Adapter<SavedListsAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listButton: Button = itemView.findViewById(androidx.appcompat.R.id.list_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val savedList = savedLists[position]
        holder.listButton.text = savedList.name
        holder.listButton.setOnClickListener {

            Log.d("SavedListsAdapter", "Clicked on saved list: ${savedList.name}")
        }
    }

    override fun getItemCount() = savedLists.size
}

class SavedListPlaceholder(val id: Int, val name: String)
