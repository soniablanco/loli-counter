package soni.example.loli_counter

import kotlin.random.Random

class Loli(val mom:Mom) {
    fun count(){
        var random = Random.nextInt(3)
        mom.multiplyByTwo(random)
    }
}