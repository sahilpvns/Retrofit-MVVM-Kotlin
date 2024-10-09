package com.sahilpvns.retrofitmvvmkotlin.network

sealed class NetworkResponse() {
    data class Success<T>(val data: T) : NetworkResponse()
    data class Error(val message: String) : NetworkResponse()
    data object Loading : NetworkResponse()
}