package com.nkmr.myrealm

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.nkmr.myrealm.model.Dog
import com.nkmr.myrealm.model.User
import com.vicpin.krealmextensions.save
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    init {
//        button.setOnClickListener {
////            startActivity(Intent(this, Main2Activity::class.java))
//        }
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var u = User()
        u.name = "Yuta"
        u.email = "yuta.nakamura.i7@gmail.com"
//        u.dogs.add( {
//            var pu = Dog()
//            pu.name = "Puu Chan"
//            pu
//        }())
        u.save()
    }
}
