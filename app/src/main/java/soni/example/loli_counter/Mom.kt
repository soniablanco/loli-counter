package soni.example.loli_counter

import android.util.Log

class Mom: Subscriptor<Int> {
    override fun onNext(value:Int){
        Log.d("Multiplied by 2 ",(value*2).toString())
    }
}