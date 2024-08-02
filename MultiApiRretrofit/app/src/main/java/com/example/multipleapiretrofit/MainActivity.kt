package com.example.multipleapiretrofit


import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.multipleapiretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdpt: RecyclerViewAdpt
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.recyclerView
        initRecyclerView()
        initViewModel()
        searchUser()

    }

    private fun searchUser() {
        val searchText = binding.searchEditTxt.text.toString()
        val Search = binding.searchBtn

        Search.setOnClickListener {
            if (!TextUtils.isEmpty(searchText)) {
                viewModel.searchUser(searchText)
            } else {
                //viewModel.searchUser(searchbtn)
                viewModel.getUserList()
            }
        }
    }

    private fun initRecyclerView() {
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration =
                DividerItemDecoration(this@MainActivity, DividerItemDecoration.HORIZONTAL)
            addItemDecoration(decoration)

            recyclerViewAdpt = RecyclerViewAdpt()
            adapter = recyclerViewAdpt

        }
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.inti(this@MainActivity)
        viewModel.getUserListObserverable().observe(this, Observer<List<User>?> { userList ->
            if (userList == null) {
                Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show()
            } else {
                recyclerViewAdpt.userList = userList.toMutableList()
                recyclerViewAdpt.notifyDataSetChanged()
            }
        })
        viewModel.getUserList()
    }




}