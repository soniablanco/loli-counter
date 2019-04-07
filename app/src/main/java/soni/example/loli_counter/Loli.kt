package soni.example.loli_counter

import kotlin.random.Random

class Loli(val dad:Dad) {
    fun count(){
        var random = Random.nextInt(3)
        dad.action(random)
    }
}