package com.hfad.finalproject

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DeleteFragment : Fragment() {

     var itemList = arrayListOf<Item>()
     private lateinit var itemAdapter: ItemAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_delete, container, false)


        itemAdapter = ItemAdapter()
        val recyclerView: RecyclerView = view.findViewById(R.id.itemRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = itemAdapter

        val deleteButton: Button = view.findViewById(R.id.deleteButton)
        deleteButton.setOnClickListener {

            itemAdapter.notifyDataSetChanged()

            fragmentManager?.popBackStack()
        }

        return view
    }
}
