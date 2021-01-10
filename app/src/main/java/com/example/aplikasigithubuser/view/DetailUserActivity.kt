package com.example.aplikasigithubuser.view

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.aplikasigithubuser.R
import com.example.aplikasigithubuser.adapter.FollowersUserAdapter
import com.example.aplikasigithubuser.adapter.MainAdapter
import com.example.aplikasigithubuser.adapter.SectionsPagerAdapter
import com.example.aplikasigithubuser.databinding.ActivityDetailUser2Binding
import com.example.aplikasigithubuser.model.ItemsItem
import com.example.aplikasigithubuser.model.User
import com.example.aplikasigithubuser.viewModel.ViewModelDetailUserActivity
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_profile.*

class DetailUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUser2Binding
    lateinit var viewModel: ViewModelDetailUserActivity
    companion object{
        val EXTRA_DATA_USER = "data_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUser2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val getData = intent?.getParcelableExtra<User>(EXTRA_DATA_USER)

        Glide.with(this).load(getData?.imgAvatar).into(binding.ivImg)
        binding.tvUsername.text =  getData?.userName
        binding.tvName.text = ": " + getData?.Name
        binding.tvLocation.text = ": " + getData?.location
        binding.tvRepository.text = ": " + getData?.repository
        binding.tvFollowers.text = ": " + getData?.followers
        binding.tvFollowing.text = ": " + getData?.following
        binding.tvCompany.text = ": " + getData?.company

        binding.fabHome.setOnClickListener {
            onBackPressed()
        }
        viewModel = ViewModelProviders.of(this).get(ViewModelDetailUserActivity::class.java)
        viewModel.getReadFollower(getData?.userName!!)
        viewModel.getReadFollowing(getData?.userName!!)
        observer()


        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
        supportActionBar?.elevation = 0f

    }

    private fun observer() {
        viewModel.responSuccessFollowing.observe(this, Observer {  showDataFollowingUser(it) })
        viewModel.responErrorFollowing.observe(this, Observer {
            Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show()
        })

        viewModel.responSuccessFollower.observe(this, Observer {  showDataFollowerUser(it) })
        viewModel.responErrorFollower.observe(this, Observer {
            Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show()
        })
    }
    private fun showDataFollowerUser(it: List<ItemsItem>?) {
      list_user2.adapter = FollowersUserAdapter(it)
    }

    private fun showDataFollowingUser(it: List<ItemsItem>?) {

        list_user3.adapter = FollowersUserAdapter(it)
    }

}