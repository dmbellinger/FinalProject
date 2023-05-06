package com.hfad.finalproject
//Dylan Bellinger
//Steven Griffin
// 5/5/2023
//Final Project
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ViewListFragment : Fragment() {

    private lateinit var itemList: MutableList<Item>
    private lateinit var itemAdapter: ItemAdapter
    private val viewModel: ItemsViewModel by activityViewModels {
        ItemsViewModelFactory(
            (activity?.application as ListApplication).database.DAO(),
            (activity?.application as ListApplication).database.SavedDAO()
        )
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_list, container, false)


        itemAdapter = ItemAdapter(viewModel)
        val recyclerView: RecyclerView = view.findViewById(R.id.itemRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = itemAdapter

        //Buttons for list fragment
        val deleteButton: Button = view.findViewById(R.id.deleteButton)
        deleteButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_viewListFragment_to_deleteFragment)
        }

        val addButton: Button = view.findViewById(R.id.AddScreenButton)
        addButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_viewListFragment_to_addFragment)
        }

        val savedListsButton: Button = view.findViewById(R.id.SaveButton)
        savedListsButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_viewListFragment_to_savedFragment)
        }

        val shareButton: Button = view.findViewById(R.id.share_button)
        shareButton.setOnClickListener {
            val listText: String = getListText()
            shareList(listText)
        }
        val priceTotal: TextView = view.findViewById(R.id.PriceTotal)
        val items = viewModel.getItems()
        var totalPrice = 0
        for (item in items){
            totalPrice = (totalPrice + (item.quantity.toInt() * item.price).toInt())
        }
        priceTotal.text = totalPrice.toString()

        return view
    }

    //Function for retrieving list text
    private fun getListText(): String {
        val stringBuilder = StringBuilder()
        val itemsList = viewModel.getItems()//_currentList.value ?: return ""
        for (item in itemsList) {
            stringBuilder.append(item.name)
            stringBuilder.append("\t")
            stringBuilder.append(item.price)
            stringBuilder.append("\t")
            stringBuilder.append(item.quantity)
            stringBuilder.append("\n")
        }
        return stringBuilder.toString()
    }

    // Function to share the list
    private fun shareList(listText: String) {
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, listText)
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(shareIntent)
    }
}
