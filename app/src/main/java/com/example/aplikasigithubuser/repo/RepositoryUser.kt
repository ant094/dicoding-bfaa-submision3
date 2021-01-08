package com.example.aplikasigithubuser.repo

import com.example.aplikasigithubuser.config.Network
import com.example.aplikasigithubuser.model.ResponseSearchUser
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class RepositoryUser {
    fun read(user : String,responHandler: (ResponseSearchUser) -> Unit, errorHandler: (Throwable) -> Unit) {
        val readData = Network.service().getData(user)
        readData.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }
}