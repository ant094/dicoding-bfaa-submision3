package com.example.aplikasigithubuser.repo

import com.example.aplikasigithubuser.config.Network
import com.example.aplikasigithubuser.model.ItemsItem
import com.example.aplikasigithubuser.model.Response
import com.example.aplikasigithubuser.model.ResponseFollower
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class RepositoryUser {
    fun readSearch(user : String, responHandler: (Response) -> Unit, errorHandler: (Throwable) -> Unit) {
        val readData = Network.service().getDataSearch(user)
        readData.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }
    fun readFollower(username : String, responHandler: (List<ItemsItem>) -> Unit, errorHandler: (Throwable) -> Unit) {
        val readData = Network.service().getDataFollower(username)
        readData.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    } fun readFollowing(username : String, responHandler: (List<ItemsItem>) -> Unit, errorHandler: (Throwable) -> Unit) {
        val readData = Network.service().getDataFollowing(username)
        readData.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }
}