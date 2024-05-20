package com.sahilpvns.retrofitmvvmkotlin.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sahilpvns.retrofitmvvmkotlin.databinding.ItemListBinding
import com.sahilpvns.retrofitmvvmkotlin.model.UsersInfo


class UsersAdapter(private var postsList: ArrayList<UsersInfo>) : RecyclerView.Adapter<UsersAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postsList[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int = postsList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(posts: ArrayList<UsersInfo>) {
        postsList = posts
        notifyDataSetChanged()
    }

    class PostViewHolder(var binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: UsersInfo) {
            binding.data = post
            binding.tvId.text = String.format(post.id.toString() + ".")
        }
    }
}