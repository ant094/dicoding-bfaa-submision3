package com.example.aplikasigithubuser.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.aplikasigithubuser.databinding.ActivityDetailUser2Binding
import com.example.aplikasigithubuser.databinding.ActivityMainBinding
import com.example.aplikasigithubuser.model.User

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUser2Binding
    companion object{
        val EXTRA_DATA_USER = "data_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUser2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val getData = intent?.getParcelableExtra<User>(EXTRA_DATA_USER)

        Glide.with(this).load(getData?.imgAvatar).into(binding.ivImg)
        binding.tvUsername.text = ": " + getData?.userName
        binding.tvName.text = ": " + getData?.Name
        binding.tvLocation.text = ": " + getData?.location
        binding.tvRepository.text = ": " + getData?.repository
        binding.tvFollowers.text = ": " + getData?.followers
        binding.tvFollowing.text = ": " + getData?.following
        binding.tvCompany.text = ": " + getData?.company

        binding.fabHome.setOnClickListener {
         onBackPressed()
        }
    }
}