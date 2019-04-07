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
        loli.subscribe(object: Subscriptor<Int>{
            override fun onNext(value: Int) {
                Log.d("New number",value.toString())
            }
        })
        loli.subscribe(object: Subscriptor<Int>{
            override fun onNext(value: Int) {
                Log.d("Multiplied by 2 ",(value*2).toString())
            }
        })

        val cat = Cat()

        cat.subscribe(object: Subscriptor<String>{
            override fun onNext(value:String){
                Log.d("cat says ",value)
            }
        })

        button.setOnClickListener {
            loli.count()
            cat.meow()
        }

        val clickSource = ClickSource(button_clicks)
        clickSource.subscribe(object:Subscriptor<Unit>{
            override fun onNext(value: Unit) {
                Log.d("Click source","Click got hit")
            }
        })
    }
}
