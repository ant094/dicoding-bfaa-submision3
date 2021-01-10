package com.example.aplikasigithubuser.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.aplikasigithubuser.databinding.ActivityDetailSearchUserBinding
import com.example.aplikasigithubuser.model.ItemsItem

class DetailSearchUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailSearchUserBinding
    companion object{
        val EXTRA_DATA_USER = "data_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSearchUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val getData = intent?.getParcelableExtra<ItemsItem>(DetailSearchUserActivity.EXTRA_DATA_USER)
        binding.tvUsernameDSU.text = getData?.login
        Glide.with(binding.imgPhoto.context)
            .load(getData?.avatarUrl)
            .into(binding.imgPhoto)
    }
}