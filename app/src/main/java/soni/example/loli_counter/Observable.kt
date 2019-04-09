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


   fun<U> map(transformer:((T)->U)):Observable<U>{
       val observableResult = object:Observable<U>(){ }
        this.subscribe {
            val resultOp:U = transformer(it)
            observableResult.emit(resultOp)

        }
        return observableResult
    }
}