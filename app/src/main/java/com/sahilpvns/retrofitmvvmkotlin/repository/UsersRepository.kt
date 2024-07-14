package com.sahilpvns.retrofitmvvmkotlin.repository

import com.sahilpvns.retrofitmvvmkotlin.model.UserPhoto
import com.sahilpvns.retrofitmvvmkotlin.model.UsersInfo
import com.sahilpvns.retrofitmvvmkotlin.network.NetworkClient


class UsersRepository {
    private val postService = NetworkClient.apiService

    // Fetch posts from the API
    suspend fun getPosts(): List<UsersInfo?> {
        return postService.getPosts()
    }

    // Fetch photos from the API
    suspend fun getPhoto(): List<UserPhoto?> {
        return postService.getPhoto()
    }
}