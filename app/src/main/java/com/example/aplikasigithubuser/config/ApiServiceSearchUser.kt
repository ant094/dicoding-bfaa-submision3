package com.example.aplikasigithubuser.config

import com.example.aplikasigithubuser.model.ResponseSearchUser
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceSearchUser {
    @GET("users")
    fun getData(@Query("q") id: String): Flowable<ResponseSearchUser>
}