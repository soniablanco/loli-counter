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

        val cat = Cat()

        cat.subscribe{
            Log.d("cat says ",it)
        }

        button.setOnClickListener {
            loli.count()
            cat.meow()
        }

        val clickSource = ClickSource(button_clicks)
        clickSource.subscribe{
            Log.d("Click source","Click got hit")
        }
    }
}
