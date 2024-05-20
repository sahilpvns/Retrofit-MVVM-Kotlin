package com.sahilpvns.retrofitmvvmkotlin.repository

import com.sahilpvns.retrofitmvvmkotlin.model.UsersInfo
import com.sahilpvns.retrofitmvvmkotlin.network.NetworkClient


class UsersRepository {
    private val postService = NetworkClient.api

    suspend fun getPosts(): ArrayList<UsersInfo> {
        return postService.getPosts()
    }
}