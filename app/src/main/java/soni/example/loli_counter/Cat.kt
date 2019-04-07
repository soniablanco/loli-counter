package soni.example.loli_counter

import kotlin.random.Random

class Cat {
    private val familyMember:MutableList<FamilyMember<String>> = mutableListOf()

    private val meows = listOf("Meow","Purr","Hiss")
    fun addFamilyMember(member:FamilyMember<String>){
        familyMember.add(member)
    }
    fun meow(){
        val meow = randomMeow()
        familyMember.forEach{
            it.action(meow)
        }
    }

    private fun randomMeow():String{
        val random = Random.nextInt(3)
        return meows[random]
    }
}