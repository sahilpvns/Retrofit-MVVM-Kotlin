package com.sahilpvns.retrofitmvvmkotlin.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahilpvns.retrofitmvvmkotlin.adapter.UserInfoAdapter
import com.sahilpvns.retrofitmvvmkotlin.databinding.ActivityUserInfoBinding
import com.sahilpvns.retrofitmvvmkotlin.viewmodel.UsersViewModel

class UserInfoActivity : AppCompatActivity() {

    private val viewModel: UsersViewModel by viewModels()
    private lateinit var binding: ActivityUserInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize ViewModel
        rvLayoutManager()
        viewModelObserve()
        viewModel.fetchPosts()
        viewModel.error.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

    }

    // Observe the ViewModel's LiveData
    private fun viewModelObserve() {
        viewModel.vmPosts.observe(this) {
            binding.rvList.adapter = UserInfoAdapter(it)
            binding.progressBar.visibility = View.GONE
        }
    }

    // Set up RecyclerView layout manager
    private fun rvLayoutManager() {
        binding.rvList.layoutManager = LinearLayoutManager(this)
    }

}