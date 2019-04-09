package soni.example.loli_counter.clicks

import android.view.View
import soni.example.loli_counter.Observable

class ClickSource(private val view: View): Observable<View>() {
    init{
        view.setOnClickListener {
           emit(it)
        }
    }
}