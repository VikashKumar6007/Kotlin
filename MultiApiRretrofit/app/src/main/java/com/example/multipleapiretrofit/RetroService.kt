package com.example.multipleapiretrofit

import android.widget.EditText
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface RetroService {
    //    https://gorest.co.in/public/v2/users
//    users https://gorest.co.in/public/v2/users?name=a    public/v2/users"
    @GET("users")
   @Headers("Accept:application/json", "Content-Type:application/json")
    fun getUserList(): Call<List<User>>


    //https://gorest.co.in/public/v2/users?name=E
    @GET("users")
   // @Headers("Accept:application/json", "Content-Type:application/json")
    fun searchUser(@Query("name") searchText: String): Call<List<User>>
//
//    //    https://gorest.co.in/public/v2/users/6972434
//    //  we will use this api for edit the txt with same user
//    @GET("users/{user_id}")
//    @Headers("Accept:application/json", "Content-Type:application/json")
//    fun getUser(@Path("user_id") user_id: String): Call<UserList>

//    @PATCH("users/{user_id}")
//    @Headers(
//        "Accept:application/json",
//        "Content-Type:application/json",
//        "Authorization: Bearer 815806560b245d85d6c0452d90e5c87f372d1905ed2400802c01ed2d66123b96"
//    )
//    fun updateUser(@Path("user_id") user_id: String, @Body params: User): Call<UserResponse>
//
//    @POST("users")
//    @Headers(
//        "Accept:application/json",
//        "Content-Type:application/json",
//        "Authorization: Bearer 815806560b245d85d6c0452d90e5c87f372d1905ed2400802c01ed2d66123b96"
//    )
//    fun createUser(@Body params: User): Call<UserResponse>
//
//    //    for delete
//    @DELETE("users/{user_id}")
//    @Headers(
//        "Accept:application/json",
//        "Content-Type:application/json",
//        "Authorization: Bearer 815806560b245d85d6c0452d90e5c87f372d1905ed2400802c01ed2d66123b96"
//    )
//    fun deleteUser(@Path("user_id") user_id: String): Call<UserResponse>
}