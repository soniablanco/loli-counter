package soni.example.loli_counter.reactive2

import kotlin.random.Random

class Comeloni(private val myfunction:(Observer2<Int>)->Unit = fun (observer:Observer2<Int>){ //Funtion that will be executed every time a new observer subscribes to the Observable
    val  arrry= listOf(3,3,4,2,32,3)
    for (numero in arrry){
        observer.onNext(numero)
    }
    //lo importante aca es q cada vez q se suscriben se ejecuta la funcion osea recibe una nueva rafaga de valores osea no es compartida es unicast

    //muy bien pisquiio sube este codigo y ya te llamo y te digo q hacer
    observer.onComplete()
}):Observable2<Int>(myfunction){


///excellente pisqui
    /*fun myfunction(observer:Observer2<Int>){
        observer.onNext(Random.nextInt())
    }*/
}