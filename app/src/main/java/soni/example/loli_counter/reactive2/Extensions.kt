package soni.example.loli_counter.reactive2

fun<T> Observable2<T>.subscribe(onNext:(T)->Unit){//Extends Observable2<T> by overloading the subscribe method
    this.subscribe(object:Observer2<T>{
        override fun onComplete() {

        }

        override fun onNext(value: T) {
            onNext(value)
            //jjeje listo!!
            // si mas boba
        }
    })
}

fun<U,T> Observable2<T>.map(transformer:((T)->U)):Observable2<U>{
    val root = this
    val observableResult = object:Observable2<U>(
        fun (observer:Observer2<U>){ 
            root.subscribe{// subscribing to the root observable to make it emit and after emiting take the result as input for the next on mapobserver()
                observer.onNext(transformer(it))
            }
            observer.onComplete()
        }
    ){ }

    return observableResult
}