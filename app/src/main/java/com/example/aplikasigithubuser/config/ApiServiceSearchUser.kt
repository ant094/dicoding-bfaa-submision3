package com.example.aplikasigithubuser.config

import com.example.aplikasigithubuser.model.ItemsItem
import com.example.aplikasigithubuser.model.Response
import com.example.aplikasigithubuser.model.ResponseFollower
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceSearchUser {
    @GET("search/users")
    fun getDataSearch(@Query("q") id: String): Flowable<Response>

    @GET("users/{username}/followers")
    fun getDataFollower(@Path("username") username : String) : Flowable<List<ItemsItem>>
    @GET("users/{username}/following")
    fun getDataFollowing(@Path("username") username : String) : Flowable<List<ItemsItem>>
}