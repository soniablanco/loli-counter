package soni.example.loli_counter

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import soni.example.loli_counter.network.CoinsService

class LoliCounterApplication: Application(){
    lateinit var networkService: CoinsService
    //todo eso tiene que ir adeentro
    //bueno desoyes me dices como funciona eso

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.coinmarketcap.com/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

        networkService = retrofit.create(CoinsService::class.java)
    }
}