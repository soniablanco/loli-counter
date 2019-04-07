package soni.example.loli_counter

import kotlin.random.Random

class Cat:Emisor<String>() {

    private val meows = listOf("Meow","Purr","Hiss")

    fun meow(){
        val meow = randomMeow()
        subscritors.forEach{
            it.action(meow)
        }
    }

    private fun randomMeow():String{
        val random = Random.nextInt(3)
        return meows[random]
    }
}


