package soni.example.loli_counter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import soni.example.loli_counter.network.Coin

class NetworkObservable(val application: LoliCounterApplication):Observable<Response<List<Coin>>>() {
    fun fetchData(){
        val call = application.networkService.getCoins(50)
        call.enqueue(object: Callback<List<Coin>> {
            override fun onResponse(call: Call<List<Coin>>, response: Response<List<Coin>>) {
                emit(response)
            }
            override fun onFailure(call: Call<List<Coin>>, t: Throwable) {

            }

        })
    }
}