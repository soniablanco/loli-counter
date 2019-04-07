package soni.example.loli_counter

abstract class Emisor<T> {
    protected val subscritors:MutableList<Subscriptor<T>> = mutableListOf()
    fun addSubscriptor(member:Subscriptor<T>){
        subscritors.add(member)
    }
}