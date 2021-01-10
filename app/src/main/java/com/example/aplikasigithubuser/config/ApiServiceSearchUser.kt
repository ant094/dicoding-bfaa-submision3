package com.example.aplikasigithubuser.config

import com.example.aplikasigithubuser.model.ItemsItem
import com.example.aplikasigithubuser.model.ResponseSearchUser
import com.example.aplikasigithubuser.model.ResponseUser
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceSearchUser {

    @GET("search/users")
    fun getDataSearch(
        @Query("q") id: String,
        @Header("Authorization") header: String = "dd1439ac42e5f24c1206638221a12bef64eadca6"
    ): Flowable<ResponseSearchUser>

    @GET("users/{username}")
    fun getDataDetail(
        @Path("username") username: String,
        @Header("Authorization") header: String = "dd1439ac42e5f24c1206638221a12bef64eadca6"
    ): Single<ResponseUser>

    @GET("users/{username}/followers")
    fun getDataFollower(
        @Path("username") username: String,
        @Header("Authorization") header: String = "dd1439ac42e5f24c1206638221a12bef64eadca6"
    ): Flowable<List<ItemsItem>>

    @GET("users/{username}/following")
    fun getDataFollowing(
        @Path("username") username: String,
        @Header("Authorization") header: String = "dd1439ac42e5f24c1206638221a12bef64eadca6"
    ): Flowable<List<ItemsItem>>
}