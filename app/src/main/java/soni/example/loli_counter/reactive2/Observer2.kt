package soni.example.loli_counter.reactive2

interface Observer2<T> {
    fun onNext(value:T)

    fun onComplete()
}