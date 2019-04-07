package soni.example.loli_counter

abstract class Emisor<T> {
    protected val familyMembers:MutableList<FamilyMember<T>> = mutableListOf()
    fun addFamilyMember(member:FamilyMember<T>){
        familyMembers.add(member)
    }
}