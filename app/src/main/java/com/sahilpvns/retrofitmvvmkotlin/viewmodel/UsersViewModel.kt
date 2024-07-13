package com.sahilpvns.retrofitmvvmkotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sahilpvns.retrofitmvvmkotlin.model.UsersInfo
import com.sahilpvns.retrofitmvvmkotlin.repository.UsersRepository
import kotlinx.coroutines.launch


class UsersViewModel(application: Application) : AndroidViewModel(application) {
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