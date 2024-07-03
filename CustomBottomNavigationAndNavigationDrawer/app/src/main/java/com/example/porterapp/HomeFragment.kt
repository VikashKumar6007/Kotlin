package com.example.porterapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.porterapp.databinding.FragmentHomeBinding




class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HomeAdapter
    private lateinit var itemList :ArrayList<HomeDataCls>

    lateinit var Image:Array<Int>
    lateinit var name :Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        dataInitialize()
//        val  layoutManager = GridLayoutManager(context,2)
//        //recyclerView = binding.rec1
//        recyclerView.layoutManager = layoutManager
//        recyclerView.setHasFixedSize(true)
//        adapter = HomeAdapter(itemList)
//        recyclerView.adapter = adapter
    }
//   private fun  dataInitialize(){
//       itemList = arrayListOf(
//           HomeDataCls(R.drawable.pickup, "Truck 1"),
//           HomeDataCls(R.drawable.pickup, "Pick up"),
//           HomeDataCls(R.drawable.pickup, "Auto"),
//           HomeDataCls(R.drawable.pickup, "Bike"),
//           HomeDataCls(R.drawable.pickup, "Truck 2"),
//           HomeDataCls(R.drawable.pickup, "Truck 3"),
//           HomeDataCls(R.drawable.pickup, "Truck 1"),
//           HomeDataCls(R.drawable.pickup, "Truck 2"),
//           HomeDataCls(R.drawable.pickup, "Truck 3"),
//           HomeDataCls(R.drawable.pickup, "Truck 1"),
//           HomeDataCls(R.drawable.pickup, "Truck 2"),
//           HomeDataCls(R.drawable.pickup, "Truck 3")
//       )
//
//
//   }



}