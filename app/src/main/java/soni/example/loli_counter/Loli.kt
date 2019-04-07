package soni.example.loli_counter

import kotlin.random.Random

class Loli(private val mom:Mom, private val dad:Dad) {
    fun count(){
        val random = Random.nextInt(3)
        mom.multiplyByTwo(random)
        dad.action(random)
    }
}