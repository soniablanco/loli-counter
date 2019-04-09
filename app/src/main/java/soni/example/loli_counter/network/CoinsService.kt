package soni.example.loli_counter.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinsService {
    @GET("ticker")
    fun getCoins(@Query("limit") limit: Int): Call<List<Coin>>
}