package com.hfad.finalproject

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.List

class SavedListsAdapter(viewModel: ItemsViewModel) : RecyclerView.Adapter<SavedListsAdapter.ViewHolder>() {
    val viewModel = viewModel
    val savedList = viewModel.getSavedLists()
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listname: TextView = itemView.findViewById(R.id.ListNameDisplay)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.saved_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = savedList[position]
        holder.listname.text = list.ListName
        holder.listname.setOnClickListener {
            viewModel.changeList(position)
            //Log.d("SavedListsAdapter", "Clicked on saved list: ${savedList.name}")
        }
    }

    override fun getItemCount() = savedList.size
}

class SavedListPlaceholder(val id: Int, val name: String)
