package soni.example.loli_counter

import android.util.Log

class Mom: FamilyMember {
    override fun action(number:Int){
        Log.d("Multiplied by 2 ",(number * 2).toString())
    }
}