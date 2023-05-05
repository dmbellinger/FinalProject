package com.hfad.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.List


class SavedFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var recyclerView: RecyclerView
    private lateinit var savedListsAdapter: SavedListsAdapter
    private val viewModel: ItemsViewModel by activityViewModels {
        ItemsViewModelFactory(
            (activity?.application as ListApplication).database.DAO(),
            (activity?.application as ListApplication).database.SavedDAO()
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_saved, container, false)
        recyclerView = view.findViewById(R.id.recycler_view_saved_lists)
        savedListsAdapter = SavedListsAdapter(viewModel)
        recyclerView.adapter = savedListsAdapter
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        val newListName = view.findViewById<EditText>(R.id.new_list_input)
        val newListButton = view.findViewById<Button>(R.id.button_add_saved_list)
        newListButton.setOnClickListener{
            viewModel.newList(newListName.text.toString())

        }
        return view
    }

    private fun getDummySavedLists(): List<SavedListPlaceholder> {
        val dummyList1 = SavedListPlaceholder(1, "Shopping List 1")
        val dummyList2 = SavedListPlaceholder(2, "Shopping List 2")
        val dummyList3 = SavedListPlaceholder(3, "Shopping List 3")
        return listOf(dummyList1, dummyList2, dummyList3)
    }
}
