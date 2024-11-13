package com.sahilpvns.retrofitmvvmkotlin.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.sahilpvns.retrofitmvvmkotlin.R
import com.sahilpvns.retrofitmvvmkotlin.adapter.UserInfoAdapter
import com.sahilpvns.retrofitmvvmkotlin.databinding.ActivityMainBinding
import com.sahilpvns.retrofitmvvmkotlin.viewmodel.UsersViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUserInfo.setOnClickListener {
            startActivity(Intent(this, UserInfoActivity::class.java))
        }

        binding.btnUserPhoto.setOnClickListener {
            startActivity(Intent(this, UserPhotoActivity::class.java))
        }

    }
}