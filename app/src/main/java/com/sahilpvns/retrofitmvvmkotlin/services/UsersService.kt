package com.sahilpvns.retrofitmvvmkotlin.services

import com.sahilpvns.retrofitmvvmkotlin.model.UsersInfo
import retrofit2.http.GET


interface UsersService {
    @GET("posts")
    suspend fun getPosts(): List<UsersInfo>
}