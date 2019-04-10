package soni.example.loli_counter.network

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CoinsServiceClient {
    private const val BASE_URL = "https://api.coinmarketcap.com/v1/"
    var retrofit: Retrofit? = null

    private var networkService: CoinsService? = null

    private fun buildClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    fun getClient():CoinsService{
        if(networkService == null)
            networkService = buildClient().create(CoinsService::class.java)
        return networkService!!
    }

    /*fun <U> retrieveData(appContext: Context, endpointUrl: String, methodName: String, classOfU: Class<U>): U {
        val call = getClient().create(CoinsService::class.java).getCoins(50)
        call.enqueue(object: Callback<List<Coin>> {
            override fun onResponse(call: Call<List<Coin>>, response: Response<List<Coin>>) {
                if(response.isSuccessful){
                    response.body()
                }
            }
            override fun onFailure(call: Call<List<Coin>>, t: Throwable) {

            }

        })
    }*/
}