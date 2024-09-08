package com.sahilpvns.retrofitmvvmkotlin.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahilpvns.retrofitmvvmkotlin.adapter.UserPhotoAdapter
import com.sahilpvns.retrofitmvvmkotlin.databinding.ActivityUserPhotoBinding
import com.sahilpvns.retrofitmvvmkotlin.viewmodel.UsersViewModel

class UserPhotoActivity : AppCompatActivity() {

    private val viewModel: UsersViewModel by viewModels()
    private lateinit var binding: ActivityUserPhotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize ViewModel
        rvLayoutManager()
        viewModelObserve()
        viewModel.fetchPhoto()

    }

    // Observe the ViewModel's LiveData
    private fun viewModelObserve() {
        viewModel.vmPhoto.observe(this) {
            binding.rvUserPhoto.adapter = UserPhotoAdapter(it)
            binding.progressBar.visibility = View.GONE
        }
    }

    // Set up RecyclerView layout manager
    private fun rvLayoutManager() {
        binding.rvUserPhoto.layoutManager = LinearLayoutManager(this)
    }

}