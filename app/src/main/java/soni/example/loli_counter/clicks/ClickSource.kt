package soni.example.loli_counter.clicks

import android.view.View
import soni.example.loli_counter.Emisor

class ClickSource(private val view: View):Emisor<Unit>() {
    init{
        view.setOnClickListener {
            subscritors.forEach{
                it.action(Unit)
            }
        }
    }
}