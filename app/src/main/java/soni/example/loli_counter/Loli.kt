package soni.example.loli_counter

import kotlin.random.Random

class Loli() {
    private val familyMember:MutableList<FamilyMember<Int>> = mutableListOf()
    fun addFamilyMember(member:FamilyMember<Int>){
        familyMember.add(member)
    }
    fun count(){
        val random = Random.nextInt(3)
        familyMember.forEach{
            it.action(random)
        }
    }
}