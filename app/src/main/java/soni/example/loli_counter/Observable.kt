package soni.example.loli_counter

abstract class Observable<T> {
    private val subscritors:MutableList<(T)->Unit> = mutableListOf()

    fun subscribe(onNext:((T)->Unit)){
        subscritors.add(onNext)
    }
    fun emit(value:T){
        for (subs in subscritors){
            subs(value)
        }
    }
}