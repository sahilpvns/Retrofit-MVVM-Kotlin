package com.sahilpvns.retrofitmvvmkotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sahilpvns.retrofitmvvmkotlin.databinding.UserPhotoListBinding
import com.sahilpvns.retrofitmvvmkotlin.model.UserPhoto

class UserPhotoAdapter(private var photoData: List<UserPhoto?>): RecyclerView.Adapter<UserPhotoAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = UserPhotoListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val photo = photoData[position]
        holder.bind(photo)
    }

    override fun getItemCount(): Int = photoData.size

    class PostViewHolder(private var binding: UserPhotoListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: UserPhoto?) {
            binding.data = photo
            Glide.with(itemView.context).load(photo?.url).into(binding.ivUserPhoto)
            binding.root.setOnClickListener {
                Toast.makeText(it.context, "Item Clicked: ${photo?.id}", Toast.LENGTH_SHORT).show()
            }

        }
    }

}