package com.sahilpvns.retrofitmvvmkotlin.model

import com.google.gson.annotations.SerializedName

data class UsersInfo(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
)