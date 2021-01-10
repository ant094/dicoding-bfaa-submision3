package com.example.aplikasigithubuser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aplikasigithubuser.R
import com.example.aplikasigithubuser.model.ItemsItem
import kotlinx.android.synthetic.main.item_list_user.view.*

class FollowersAndFollowingUserAdapter(private val data: List<ItemsItem>?) :
    RecyclerView.Adapter<FollowersAndFollowingUserAdapter.FollowersUserHolder>() {
    class FollowersUserHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val imgUser = itemView.imgUser
        val usernameUser = itemView.usernameUser
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowersAndFollowingUserAdapter.FollowersUserHolder {
        var view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_search_user, parent, false)
        return FollowersAndFollowingUserAdapter.FollowersUserHolder(view)
    }

    override fun onBindViewHolder(
        holder: FollowersAndFollowingUserAdapter.FollowersUserHolder,
        position: Int
    ) {
        val item = data?.get(position)
        holder.usernameUser.text = item?.login
        Glide.with(holder.imgUser.context)
            .load(item?.avatarUrl)
            .into(holder.imgUser)


    }

    override fun getItemCount(): Int = data?.size ?: 0

}