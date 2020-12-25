package com.example.aplikasigithubuser.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.aplikasigithubuser.R
import com.example.aplikasigithubuser.model.User
import kotlinx.android.synthetic.main.item_list_user.view.*

class MainAdapter(private val data: List<User>?, private val itemClick: OnClickListener) :
    RecyclerView.Adapter<MainAdapter.MainHolder>() {
    class MainHolder(itemView: View, val itemClick: OnClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val imgUser = itemView.imgUser
        val usernameUser = itemView.usernameUser
        val nameUser = itemView.nameUser
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_user, parent, false)
        return MainHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val item = data?.get(position)
        holder.usernameUser.text = item?.userName
        holder.nameUser.text = item?.Name
        Glide.with(holder.imgUser.context)
            .load(item?.imgAvatar)
            .into(holder.imgUser)

        holder.itemView.setOnClickListener {
            itemClick.detailUser(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?: 0
    interface OnClickListener {
        fun detailUser(item: User?)
    }
}