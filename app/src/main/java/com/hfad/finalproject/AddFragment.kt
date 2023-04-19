package com.hfad.finalproject

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment(), View.OnClickListener {
    val items = arrayListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.AddButton).setOnClickListener(this)
    }
    fun addItem() {
        val itemName = view?.findViewById<EditText>(R.id.ItemNameInput).toString()
        val itemPrice = view?.findViewById<EditText>(R.id.ItemPriceInput).toString().toDouble()
        val item = Item(itemName,itemPrice)
//        items.add(item)
        ItemsViewModel.ItemArray.addItem(item)
    }

    override fun onClick(view: View?) {
        addItem()

    }
    @JvmName("getItems1")
    fun getItems(): ArrayList<Item> {
        return items
    }

}

