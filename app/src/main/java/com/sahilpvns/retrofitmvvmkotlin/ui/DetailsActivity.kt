package com.sahilpvns.retrofitmvvmkotlin.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.sahilpvns.retrofitmvvmkotlin.R
import com.sahilpvns.retrofitmvvmkotlin.databinding.ActivityDetailsBinding
import com.sahilpvns.retrofitmvvmkotlin.databinding.ActivityUserPhotoBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val url = intent.getStringExtra("url")
        val title = intent.getStringExtra("title")
        val id = intent.getIntExtra("id", 0)

        binding.tvTitle.text = title
        Glide.with(this).load(url).into(binding.ivImage)




    }
}