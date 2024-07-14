package com.sahilpvns.retrofitmvvmkotlin.ui

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahilpvns.retrofitmvvmkotlin.R
import com.sahilpvns.retrofitmvvmkotlin.adapter.UserInfoAdapter
import com.sahilpvns.retrofitmvvmkotlin.adapter.UserPhotoAdapter
import com.sahilpvns.retrofitmvvmkotlin.databinding.ActivityUserPhotoBinding
import com.sahilpvns.retrofitmvvmkotlin.viewmodel.UsersViewModel

class UserPhotoActivity : AppCompatActivity() {

    private var viewModel: UsersViewModel? = null
    private var binding: ActivityUserPhotoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_photo)


        // Initialize ViewModel
        viewModelProvider()
        rvLayoutManager()
        viewModelObserve()
        viewModel?.fetchPhoto()

    }

    // Observe the ViewModel's LiveData
    private fun viewModelObserve() {
        viewModel?.vmPhoto?.observe(this) {
            binding?.rvUserPhoto?.adapter = UserPhotoAdapter(it)
            binding?.progressBar?.visibility = View.GONE
        }
    }

    // Set up RecyclerView layout manager
    private fun rvLayoutManager() {
        binding?.rvUserPhoto?.layoutManager = LinearLayoutManager(this)
    }

    // Initialize ViewModel
    private fun viewModelProvider() {
        viewModel = ViewModelProvider(this)[UsersViewModel::class.java]
    }
}