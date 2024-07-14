package com.sahilpvns.retrofitmvvmkotlin.repository

import com.sahilpvns.retrofitmvvmkotlin.model.UsersInfo
import com.sahilpvns.retrofitmvvmkotlin.network.NetworkClient


class UsersRepository {
    private val postService = NetworkClient.apiService

    suspend fun getPosts(): List<UsersInfo?> {
        return postService.getPosts()
    }
}