package com.hfad.finalproject
//Dylan Bellinger
//Steven Griffin
// 5/5/2023
//Final Project
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.util.Log
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.hfad.finalproject.databinding.FragmentAddBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment(), View.OnClickListener {
//    val items = arrayListOf<Item>()
    private val viewModel: ItemsViewModel by activityViewModels {
        ItemsViewModelFactory(
            (activity?.application as ListApplication).database.DAO(),
            (activity?.application as ListApplication).database.SavedDAO()
        )
    }
    lateinit var item:Item
    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
//        val viewModel: ItemsViewModel by viewModels()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater,container,false)
        //return inflater.inflate(R.layout.fragment_add, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.AddButton).setOnClickListener(this)
    }
    fun addItem() {
        //val itemName = view?.findViewById<EditText>(R.id.ItemNameInput)?.text.toString()
        val itemName = binding.ItemNameInput.text.toString()
        val itemPrice = binding.ItemPriceInput.text.toString().toDouble()
        val itemQuantity = binding.QuantityInput.text.toString().toInt()
        val itemCategory = binding.CategoryInput.text.toString()
        //val itemPrice = view?.findViewById<EditText>(R.id.ItemPriceInput)?.text.toString().toDouble()
//        Log.d("Tag","$itemPrice")
        //val item = Item(viewModel.currentList,itemName,itemPrice)
//        items.add(item)
       // ItemsViewModel.ItemArray.addItem(item)
        if (isEntryValid(itemName)) {
            viewModel.addItem(itemName, itemPrice, itemCategory, itemQuantity)
        }
    }

    override fun onClick(view: View?) {
        addItem()

    }
//    @JvmName("getItems1")
//    fun getItems(): ArrayList<Item> {
//        return items
//    }

    fun isEntryValid(itemName: String): Boolean{
        return viewModel.isEntryValid(binding.ItemNameInput.text.toString())
    }


}

