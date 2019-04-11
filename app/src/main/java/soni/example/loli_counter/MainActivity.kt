package soni.example.loli_counter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import soni.example.loli_counter.clicks.ClickSource
import soni.example.loli_counter.reactive2.Comeloni
import soni.example.loli_counter.reactive2.Observer2
import soni.example.loli_counter.reactive2.map
import soni.example.loli_counter.reactive2.subscribe

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

        val user =  UserObservable()
        user.subscribe {
            if(it.isSuccessful){
                Log.d("Element count", it.body()!!.username)
            }
            else{
                Log.d("Error",it.message())
            }
        }

        val comeloni = Comeloni()// Si si funciona pruebalo ssubscribete
        comeloni.subscribe(object:Observer2<Int>{
            override fun onNext(value: Int) {
                Log.d("NewObserver",value.toString())
            }

            override fun onComplete() {
//si si sirvio perfecto pisuqi!! comentarea tu coduigo para q quede de referencia y ahora porfa haz lo mismo pero con las librerias ya de rxjava
                //suscribirme a un observable?
                // primero gradle a la librerua, lluego quiere q generes un Observble.Interval  y te susbscribas y pruebs
                // luego quiero que crees un observable con Observable.Create y por ejemplo has el del loli
                //pero rpimero us la libreriea y juega con lo basisco

            }
        })

        comeloni.subscribe {
            Log.d("From extension",it.toString())
        }

        comeloni.map {
            it *3
        }.subscribe{
            Log.d("Mapping",it.toString())
        }

        //aich no he creado al observer no hay necesida aca se pasa una clase anonima pi

        /*fun<U> flapMap(banco:(T)->Observable<U>):Observable<U>{
        val observableResult = object:Observable<U>(){ }
        this.subscribe { price->
            val bancoEmisor = banco(price)
            bancoEmisor.subscribe { bankResult->
                observableResult.emit(bankResult)
            }
        }
        return observableResult
    }*/
        user.flapMap{
                val posts = PostsObservable()
                    posts.fetchData(it.body()!!.id)
                return@flapMap posts
            }
            .map {
                it.body()!![0].title + it.body()!!.size
            }
            .subscribe {
                Log.d("posts", it)
            }
            /*.subscribe{
                if(it.isSuccessful){
                    Log.d("First post", it.body()!![0].title + it.body()!!.size)
                }
                else{
                    Log.d("Error",it.message())
                }

            }*/

        button.setOnClickListener {
            loli.count()
            cat.meow()
            user.fetchData()
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
