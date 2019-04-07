package soni.example.loli_counter

import kotlin.random.Random

class Loli:Emisor<Int>() {
    fun count(){
        val random = Random.nextInt(3)
        familyMembers.forEach{
            it.action(random)
        }
    }
}