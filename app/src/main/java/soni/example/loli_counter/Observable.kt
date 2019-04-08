package soni.example.loli_counter

abstract class Observable<T> {
    protected val subscritors:MutableList<(T)->Unit> = mutableListOf()
    fun subscribe(onNext:((T)->Unit)){
        subscritors.add(onNext)
    }
}