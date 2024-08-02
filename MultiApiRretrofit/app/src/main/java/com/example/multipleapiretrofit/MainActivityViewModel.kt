package com.example.multipleapiretrofit


import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel : ViewModel() {

    lateinit var act:MainActivity
    var recyclerListData: MutableLiveData<List<User>>

    fun inti(activity: MainActivity){
        act = activity
    }
    init {
        recyclerListData = MutableLiveData()
    }

    fun getUserListObserverable(): MutableLiveData<List<User>> {
        return recyclerListData

    }

    fun getUserList() {
        // Toast.makeText(act, "hdbdj", Toast.LENGTH_LONG).show()

        val retoInstance = RetoInstance.getRetrofitInstance().create(RetroService::class.java)
        val call = retoInstance.getUserList()

        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    Toast.makeText(act, "Success: Data Retrieved", Toast.LENGTH_LONG).show()
                    recyclerListData.postValue(response.body())
                    Log.d("DinkarTAG", "onResponse: ${response.body().toString()}")
                } else {
                    Toast.makeText(act, "Else: Data Retrieved", Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(act, "onFailure: ${t.message}", Toast.LENGTH_LONG).show()
                recyclerListData.postValue(null)
            }
        })
    }


    fun searchUser(searchText: String) {

        val retoInstance = RetoInstance.getRetrofitInstance().create(RetroService::class.java)
        val call = retoInstance.searchUser(searchText)
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                if (response.isSuccessful) {
                    recyclerListData.postValue(response.body())
                } else {

                }
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

                recyclerListData.postValue(null)
            }

        })

    }


}