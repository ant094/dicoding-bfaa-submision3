package com.example.aplikasigithubuser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aplikasigithubuser.R
import com.example.aplikasigithubuser.model.ItemsItem
import com.example.aplikasigithubuser.model.User
import kotlinx.android.synthetic.main.item_list_user.view.*

class SearchUserAdapter(private val data: List<ItemsItem?>?, private val itemClick: SearchUserAdapter.OnClickListener) :
    RecyclerView.Adapter<SearchUserAdapter.SearchUserHolder>() {
    class SearchUserHolder(itemView: View, itemClick: OnClickListener) :
        RecyclerView.ViewHolder(itemView){
        val imgUser = itemView.imgUser
        val usernameUser = itemView.usernameUser
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchUserAdapter.SearchUserHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_search_user, parent, false)
        return SearchUserAdapter.SearchUserHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: SearchUserAdapter.SearchUserHolder, position: Int) {
        val item = data?.get(position)
        holder.usernameUser.text = item?.login
        Glide.with(holder.imgUser.context)
            .load(item?.avatarUrl)
            .into(holder.imgUser)

        holder.itemView.setOnClickListener {
            itemClick.detailSearchUser(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?: 0
    interface OnClickListener {
        fun detailSearchUser(item: ItemsItem?)
    }
}