package soni.example.loli_counter.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {
    @GET(	"users/2")
    fun getUser(): Call<User>

    @GET(	"posts")
    fun getPosts(@Query("userId") userId: Int): Call<List<Post>>
}