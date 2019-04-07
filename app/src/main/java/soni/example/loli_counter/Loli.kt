package soni.example.loli_counter

import kotlin.random.Random

class Loli() {
    private val familyMember:MutableList<FamilyMember> = mutableListOf()
    fun addFamilyMember(member:FamilyMember){
        familyMember.add(member)
    }
    fun count(){
        val random = Random.nextInt(3)
        familyMember.forEach{
            it.action(random)
        }
    }
}