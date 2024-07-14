package com.sahilpvns.retrofitmvvmkotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.sahilpvns.retrofitmvvmkotlin.databinding.ItemListBinding
import com.sahilpvns.retrofitmvvmkotlin.model.UsersInfo


class UsersAdapter(private var postData: List<UsersInfo?>) : RecyclerView.Adapter<UsersAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postData[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int = postData.size

    class PostViewHolder(private var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: UsersInfo?) {
            binding.data = post
            binding.tvId.text = String.format(post?.id.toString() + ".")
            binding.root.setOnClickListener {
                Toast.makeText(it.context, "$adapterPosition Item Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}