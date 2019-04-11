package soni.example.loli_counter.reactive2

interface Observer2<T> { //subscriber of the observable
    fun onNext(value:T) //method that is call inside the implementation of constructor function/parameter of Observable<T>, to emit data

    fun onComplete()//method that is call inside the implementation of constructor function/parameter of Observable<T>, after finishing data emition to notify the stream ended
}