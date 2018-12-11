//package com.nkmr.myrealm
//
//import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
//import android.util.Log
//import com.nkmr.myrealm.model.User
//import com.vicpin.krealmextensions.save
//import io.realm.Realm
//import kotlinx.android.synthetic.main.activity_main2.*
//import kotlinx.coroutines.experimental.Job
//import kotlinx.coroutines.experimental.android.UI
//import kotlinx.coroutines.experimental.delay
//import kotlinx.coroutines.experimental.launch
//
//class Main2Activity : AppCompatActivity() {
//
//    private var realm = Realm.getDefaultInstance()
//    private var users = realm.where(User::class.java).findAll()
//
//    override fun onDestroy() {
//        super.onDestroy()
//        users.removeAllChangeListeners()
//        job.cancel()
//    }
//
//    private lateinit var job: Job
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
//
//        button2.setOnClickListener {
//            finish()
//        }
//
//        var user = User()
//        user.name = "ゆうた"
//        user.email = "yuta.nakamura.i7@gmail.com"
//        user.save()
//
//        Log.d("userEmail", user.email)
//
//        var i = 0
//        job = launch(UI) {
//            while (true) {
//                i++
//                delay(1000)
//                user.save()
//            }
//        }
//
//        users.addChangeListener { t, changeSet ->
//            Log.d("users onChanged", "koko1 i: ${i}")
//        }
//    }
//}