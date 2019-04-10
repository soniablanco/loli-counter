package soni.example.loli_counter.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    var retrofit: Retrofit? = null

    private var networkService: Service? = null

    private fun buildClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }

    fun getClient():Service{
        if(networkService == null)
            networkService = buildClient().create(Service::class.java)
        return networkService!!
    }

    /*fun <U> retrieveData(appContext: Context, endpointUrl: String, methodName: String, classOfU: Class<U>): U {
        val call = getClient().create(Service::class.java).getCoins(50)
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