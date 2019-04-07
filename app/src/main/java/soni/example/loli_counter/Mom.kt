package soni.example.loli_counter

import android.util.Log

class Mom: FamilyMember<Int> {
    override fun action(value:Int){
        Log.d("Multiplied by 2 ",(value*2).toString())
    }
}