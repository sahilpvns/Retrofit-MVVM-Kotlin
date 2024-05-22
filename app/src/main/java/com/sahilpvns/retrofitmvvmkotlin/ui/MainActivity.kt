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

    private lateinit var viewModel: UsersViewModel
    private val mAdapter by lazy { UsersAdapter(ArrayList()) }
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModelProvider()
        rvLayoutManager()
        viewModelObserve()
        viewModel.fetchPosts()

    }

    private fun viewModelObserve() {
        viewModel.vmPost.observe(this) {
            mAdapter.setData(it)
            binding?.progressBar?.visibility = View.GONE
        }
    }

    private fun rvLayoutManager() {
        binding?.apply {
            rvList.layoutManager = LinearLayoutManager(this@MainActivity)
            rvList.adapter = mAdapter
        }
    }

    private fun viewModelProvider() {
        viewModel = ViewModelProvider(this)[UsersViewModel::class.java]
    }
}