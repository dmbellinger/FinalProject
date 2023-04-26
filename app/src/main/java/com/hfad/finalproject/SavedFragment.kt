package com.hfad.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SavedFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var recyclerView: RecyclerView
    private lateinit var savedListsAdapter: SavedListsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_saved, container, false)
        recyclerView = view.findViewById(R.id.recycler_view_saved_lists)
        savedListsAdapter = SavedListsAdapter(getDummySavedLists())
        recyclerView.adapter = savedListsAdapter
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        return view
    }

    private fun getDummySavedLists(): List<SavedListPlaceholder> {
        val dummyList1 = SavedListPlaceholder(1, "Shopping List 1")
        val dummyList2 = SavedListPlaceholder(2, "Shopping List 2")
        val dummyList3 = SavedListPlaceholder(3, "Shopping List 3")
        return listOf(dummyList1, dummyList2, dummyList3)
    }
}
