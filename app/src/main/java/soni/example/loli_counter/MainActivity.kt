package soni.example.loli_counter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loli = Loli()
        loli.addSubscriptor(object: Subscriptor<Int>{
            override fun action(value: Int) {
                Log.d("New number",value.toString())
            }
        })
        loli.addSubscriptor(object: Subscriptor<Int>{
            override fun action(value: Int) {
                Log.d("Multiplied by 2 ",(value*2).toString())
            }
        })

        val cat = Cat()

        cat.addSubscriptor(object: Subscriptor<String>{
            override fun action(value:String){
                Log.d("cat says ",value)
            }
        })

        button.setOnClickListener {
            loli.count()
            cat.meow()
        }
    }
}
