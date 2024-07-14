package com.sahilpvns.retrofitmvvmkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahilpvns.retrofitmvvmkotlin.model.UserPhoto
import com.sahilpvns.retrofitmvvmkotlin.model.UsersInfo
import com.sahilpvns.retrofitmvvmkotlin.repository.UsersRepository
import kotlinx.coroutines.launch


class UsersViewModel : ViewModel() {
    private val repository = UsersRepository()

    // LiveData to hold the list of posts
    val vmPost = MutableLiveData<List<UsersInfo?>>()
    fun fetchPosts() {
        viewModelScope.launch {
            try {
                vmPost.postValue(repository.getPosts())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    val vmPhoto: MutableLiveData<List<UserPhoto?>> = MutableLiveData()
    fun fetchPhoto() {
        viewModelScope.launch {
            try {
                vmPhoto.postValue(repository.getPhoto())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }




}