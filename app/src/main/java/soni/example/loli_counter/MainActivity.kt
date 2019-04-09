package soni.example.loli_counter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import soni.example.loli_counter.clicks.ClickSource

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loli = Loli()

        loli.subscribe{
            Log.d("New number",it.toString())
        }
        loli.subscribe{
            Log.d("Multiplied by 2 ",(it*2).toString())
        }
        loli.map { "desde mapping $it" }.subscribe { Log.d("Mapping",it) }

        val cat = Cat()

        cat.subscribe{
            Log.d("cat says ",it)
        }

        val red =  NetworkObservable(application as LoliCounterApplication)

        red.subscribe {
            if(it.isSuccessful){
                Log.d("Element count", it.body()!!.size.toString())
            }
            else{
                Log.d("Error",it.message())
            }
        }

        button.setOnClickListener {
            loli.count()
            cat.meow()
            red.fetchData()
        }

        val clickSource = ClickSource(button_clicks)
        clickSource.subscribe{
            Log.d("Click source","Click got hit")
        }



        /*val call = (application as LoliCounterApplication).networkService.getCoins(50)
        call.enqueue(object: Callback<List<Coin>>{
            override fun onResponse(call: Call<List<Coin>>, response: Response<List<Coin>>) {
                if(response.isSuccessful){
                    response.body()
                }
            }
            override fun onFailure(call: Call<List<Coin>>, t: Throwable) {
                ///sonia muestrame eso sirviendo sin nada de observable
            }

        })*/
    }
}
