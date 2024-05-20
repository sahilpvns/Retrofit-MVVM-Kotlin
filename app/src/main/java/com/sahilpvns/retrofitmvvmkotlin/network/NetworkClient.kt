package com.sahilpvns.retrofitmvvmkotlin.network

import com.sahilpvns.retrofitmvvmkotlin.services.UsersService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    val api: UsersService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UsersService::class.java)
    }
}