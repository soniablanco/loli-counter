package soni.example.loli_counter

/*
fun<U,T> Observable<T>.map(transformer:((T)->U)):Observable<U>{
    val observableResult = object:Observable<U>(){ }
    this.subscribe {
        val resultOp:U = transformer(it)
        observableResult.emit(resultOp)

    }
    return observableResult
}*/
