package com.nkmr.myrealm.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.annotations.LinkingObjects
import io.realm.annotations.PrimaryKey
import java.util.*

open class Dog(
    @PrimaryKey open var id: String = UUID.randomUUID().toString(),
    open var name: String = ""
//    @LinkingObjects("dogs")
//    open var owners: RealmList<User> = RealmList()
) : RealmObject() {

}