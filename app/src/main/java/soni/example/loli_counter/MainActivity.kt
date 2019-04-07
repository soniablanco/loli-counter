package soni.example.loli_counter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val papa = Dad()
        val mama = Mom()
        val loli = Loli()
        loli.addFamilyMember(papa)
        loli.addFamilyMember(mama)

        val cat = Cat()

        button.setOnClickListener {
            loli.count()
        }
    }
}
