package com.sahilpvns.retrofitmvvmkotlin.services

import com.sahilpvns.retrofitmvvmkotlin.model.UserPhoto
import com.sahilpvns.retrofitmvvmkotlin.model.UsersInfo
import retrofit2.Response
import retrofit2.http.GET


interface UsersService {

    // Fetch all posts
    @GET("posts")
    suspend fun getPosts(): List<UsersInfo>

    @GET("photos")
    suspend fun getPhoto(): List<UserPhoto>

}