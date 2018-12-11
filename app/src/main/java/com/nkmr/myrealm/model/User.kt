package com.nkmr.myrealm.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey
import java.util.*

open class User(
    @PrimaryKey open var id: String = UUID.randomUUID().toString(),
    open var name: String = "",
    open var email: String = ""
//    @LinkingObjects("owners")
//    open var dogs: RealmList<Dog> = RealmList()
) : RealmObject() {

}