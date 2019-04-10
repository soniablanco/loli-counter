package soni.example.loli_counter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import soni.example.loli_counter.network.ServiceClient
import soni.example.loli_counter.network.User

class UserObservable:Observable<Response<User>>() {
    fun fetchData(){
        val call = ServiceClient.getClient().getUser()
        call.enqueue(object: Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                emit(response)
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                var b =3
            }

        })
    }
}