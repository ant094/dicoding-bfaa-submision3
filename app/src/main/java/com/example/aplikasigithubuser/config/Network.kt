package com.example.aplikasigithubuser.config

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    fun service(): ApiServiceSearchUser = getRetrofit().create(ApiServiceSearchUser::class.java)
}