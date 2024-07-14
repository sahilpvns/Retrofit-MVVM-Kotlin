package com.sahilpvns.retrofitmvvmkotlin.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahilpvns.retrofitmvvmkotlin.R
import com.sahilpvns.retrofitmvvmkotlin.adapter.UsersAdapter
import com.sahilpvns.retrofitmvvmkotlin.databinding.ActivityMainBinding
import com.sahilpvns.retrofitmvvmkotlin.viewmodel.UsersViewModel

class MainActivity : AppCompatActivity() {

    private var viewModel: UsersViewModel? = null
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Initialize ViewModel
        viewModelProvider()
        rvLayoutManager()
        viewModelObserve()
        viewModel?.fetchPosts()

    }

    // Observe the ViewModel's LiveData
    private fun viewModelObserve() {
        viewModel?.vmPost?.observe(this) {
            binding?.rvList?.adapter = UsersAdapter(it)
            binding?.progressBar?.visibility = View.GONE
        }
    }

    // Set up RecyclerView layout manager
    private fun rvLayoutManager() {
           binding?.rvList?.layoutManager = LinearLayoutManager(this@MainActivity)
    }

    // Initialize ViewModel
    private fun viewModelProvider() {
        viewModel = ViewModelProvider(this)[UsersViewModel::class.java]
    }
}