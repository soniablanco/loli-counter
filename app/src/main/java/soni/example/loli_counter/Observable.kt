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

    fun<U> flapMap(banco:(T)->Observable<U>):Observable<U>{
        val observableResult = object:Observable<U>(){ }
        this.subscribe { price->
            val bancoEmisor = banco(price)
            bancoEmisor.subscribe { bankResult->
                observableResult.emit(bankResult)
            }
        }
        return observableResult
    }

}