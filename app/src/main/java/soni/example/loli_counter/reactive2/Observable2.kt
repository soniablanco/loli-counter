package soni.example.loli_counter.reactive2

abstract class Observable2<T>(val subscription:(Observer2<T>)->Unit){
    fun subscribe(observer:Observer2<T>){
        subscription(observer)
    }
}//dejame mirar priero // perfecto!!!