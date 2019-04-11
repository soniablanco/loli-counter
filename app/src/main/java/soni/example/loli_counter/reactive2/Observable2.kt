package soni.example.loli_counter.reactive2

abstract class Observable2<T>(val subscription:(Observer2<T>)->Unit){ // Base class receives as parameter the function it has to execute everytime a new observer subscribes to the observable
    fun subscribe(observer:Observer2<T>){
        subscription(observer)
    }
}//dejame mirar priero // perfecto!!!

//muestrrame una extension srieiviendo