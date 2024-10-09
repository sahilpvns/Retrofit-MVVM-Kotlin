package com.sahilpvns.retrofitmvvmkotlin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahilpvns.retrofitmvvmkotlin.model.UserPhoto
import com.sahilpvns.retrofitmvvmkotlin.model.UsersInfo
import com.sahilpvns.retrofitmvvmkotlin.repository.UsersRepository
import kotlinx.coroutines.launch


class UsersViewModel : ViewModel() {
    private val repository = UsersRepository()

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _vmPost = MutableLiveData<List<UsersInfo>>()
    val vmPosts: LiveData<List<UsersInfo>> = _vmPost

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                if (repository.getPosts().isNotEmpty()) {
                    _vmPost.value = repository.getPosts()
                } else {
                    _error.value = "No Data Found"
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
    }



    private val _vmPhoto = MutableLiveData<List<UserPhoto>>()
    val vmPhoto: LiveData<List<UserPhoto>> = _vmPhoto

    fun fetchPhoto() {
        viewModelScope.launch {
            try {
                if (repository.getPhoto().isNotEmpty()) {
                    _vmPhoto.value = repository.getPhoto()
                } else {
                    _error.value = "No Data Found"
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }



}