package soni.example.loli_counter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import soni.example.loli_counter.network.Post
import soni.example.loli_counter.network.ServiceClient


class PostsObservable : Observable<Response<List<Post>>>() {
    fun fetchData(userId:Int){
        val call = ServiceClient.getClient().getPosts(userId)
        call.enqueue(object: Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                emit(response)
            }
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })
    }
}