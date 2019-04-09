package soni.example.loli_counter

import kotlin.random.Random

class Loli:Observable<Int>() {
    fun count(){
        val random = Random.nextInt(3)
        emit(random)
    }
}