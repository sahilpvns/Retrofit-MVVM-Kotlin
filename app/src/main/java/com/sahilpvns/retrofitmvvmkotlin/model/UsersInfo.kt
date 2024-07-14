package com.sahilpvns.retrofitmvvmkotlin.model

import com.google.gson.annotations.SerializedName

data class UsersInfo(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("body") val body: String? = null,
)

data class UserPhoto(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("url") val url: String? = null,
)