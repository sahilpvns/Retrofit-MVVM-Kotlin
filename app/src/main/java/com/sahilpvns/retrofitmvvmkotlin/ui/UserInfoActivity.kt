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
import com.sahilpvns.retrofitmvvmkotlin.R.layout
import com.sahilpvns.retrofitmvvmkotlin.adapter.UserInfoAdapter
import com.sahilpvns.retrofitmvvmkotlin.databinding.ActivityUserInfoBinding
import com.sahilpvns.retrofitmvvmkotlin.viewmodel.UsersViewModel

class UserInfoActivity : AppCompatActivity() {

    private var viewModel: UsersViewModel? = null
    private var binding: ActivityUserInfoBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layout.activity_user_info)

        // Initialize ViewModel
        viewModelProvider()
        rvLayoutManager()
        viewModelObserve()
        viewModel?.fetchPosts()

    }

    // Observe the ViewModel's LiveData
    private fun viewModelObserve() {
        viewModel?.vmPost?.observe(this) {
            binding?.rvList?.adapter = UserInfoAdapter(it)
            binding?.progressBar?.visibility = View.GONE
        }
    }

    // Set up RecyclerView layout manager
    private fun rvLayoutManager() {
        binding?.rvList?.layoutManager = LinearLayoutManager(this)
    }

    // Initialize ViewModel
    private fun viewModelProvider() {
        viewModel = ViewModelProvider(this)[UsersViewModel::class.java]
    }
}