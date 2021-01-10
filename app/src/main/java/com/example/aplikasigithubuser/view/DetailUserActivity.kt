package com.example.aplikasigithubuser.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.aplikasigithubuser.adapter.SectionsPagerAdapter
import com.example.aplikasigithubuser.databinding.ActivityDetailUser2Binding
import com.example.aplikasigithubuser.model.ResponseUser
import com.example.aplikasigithubuser.model.User
import com.google.android.material.tabs.TabLayout

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUser2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUser2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get Data dari MainActivity
        val getData = intent?.getParcelableExtra<User>(MainActivity.EXTRA_DATA_USER)
        val getResponData =
            intent?.getParcelableExtra<ResponseUser>(MainActivity.EXTRA_RESPON_DATA_USER)

        if (getData?.userName !== null) {
            loadDataUser(getData)
        } else {
            loadResponDataUser(getResponData)
        }

        binding.fabHome.setOnClickListener {
            onBackPressed()
        }

//        Config Tab Layout
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        supportActionBar?.elevation = 0f
        FollowerFragment.username = getData?.userName ?: getResponData?.login
        FollowingFragment.username = getData?.userName ?: getResponData?.login
    }

    private fun loadResponDataUser(responData: ResponseUser?) {
        Glide.with(this).load(responData?.avatarUrl).into(binding.ivImg)
        binding.tvUsername.text = responData?.login
        binding.tvName.text = ": " + responData?.name
        binding.tvLocation.text = ": " + responData?.location
        binding.tvRepository.text = ": " + responData?.publicRepos
        binding.tvFollowers.text = ": " + responData?.followers
        binding.tvFollowing.text = ": " + responData?.following
        binding.tvCompany.text = ": " + responData?.company
    }

    private fun loadDataUser(getData: User?) {
        Glide.with(this).load(getData?.imgAvatar).into(binding.ivImg)
        binding.tvUsername.text = getData?.userName
        binding.tvName.text = ": " + getData?.Name
        binding.tvLocation.text = ": " + getData?.location
        binding.tvRepository.text = ": " + getData?.repository
        binding.tvFollowers.text = ": " + getData?.followers
        binding.tvFollowing.text = ": " + getData?.following
        binding.tvCompany.text = ": " + getData?.company
    }

}