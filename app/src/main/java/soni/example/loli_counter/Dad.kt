package soni.example.loli_counter

import android.util.Log

class Dad:Subscriptor<Int> {
    override fun action(value:Int){
        Log.d("New number",value.toString())
    }
}