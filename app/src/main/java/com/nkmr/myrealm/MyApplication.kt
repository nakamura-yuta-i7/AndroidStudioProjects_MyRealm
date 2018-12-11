package com.nkmr.myrealm

import android.app.Application
import android.util.Log
import com.facebook.stetho.Stetho
import com.uphyca.stetho_realm.RealmInspectorModulesProvider
import io.realm.Realm
import io.realm.RealmConfiguration
import java.util.regex.Pattern

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d("MyApplication.onCreate", "koko!!!")

        // Realmデータベースを使う為の初期化
        Realm.init(this)

        // Realm用暗号化キー
        // Realm Browser で default.realm を開く際にこれを指定していないと開けなかったので暫定的に指定
        // val key = "1234567890123456789012345678901234567890123456789012345678901234" // 64文字

        // マイグレーションが必要となった場合には
        // このページを参考に実装
        // see: https://realm.io/jp/docs/java/latest/#section-47
        var config = RealmConfiguration.Builder()
            .schemaVersion(0)
            .deleteRealmIfMigrationNeeded()
            // Realm Browser だと暗号化しないと開けなかった
            // でも、Stethoだと暗号化すると開けなかった, 開発効率的にStethoの方が断然良いので暗号化は停止
            //.encryptionKey(key.toByteArray())
            .build()

        // 開発初期は頻繁にDBの構成が変わる為、マイグレーションが手間となる。
        // そんな時はこれで初期化可能。
        Realm.deleteRealm(config)
        Realm.setDefaultConfiguration(config)

        // Realm Browser がやや面倒なので、Chrome & Stetho でデバッグしてみる
        // see: http://qiita.com/zaki50/items/24a6d5a2176adc092b33
        var stethoConfig = RealmInspectorModulesProvider.builder(this)
            //.withFolder(getCacheDir())
            // Stethoだと暗号化すると開けずアプリが強制停止してしまう
            //.withDefaultEncryptionKey(key.toByteArray())
            //.withEncryptionKey("default.realm", key.toByteArray())
            .withMetaTables()
            .withDescendingOrder()
            .withLimit(1000)
            .databaseNamePattern(Pattern.compile(".+\\.realm"))
            .build()

        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(stethoConfig)
                .build())
    }
}