package com.sahilpvns.retrofitmvvmkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahilpvns.retrofitmvvmkotlin.model.UsersInfo
import com.sahilpvns.retrofitmvvmkotlin.repository.UsersRepository
import kotlinx.coroutines.launch


class UsersViewModel : ViewModel() {
    private val repository = UsersRepository()
    val vmPost: MutableLiveData<List<UsersInfo>> = MutableLiveData()

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                vmPost.postValue(repository.getPosts())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}