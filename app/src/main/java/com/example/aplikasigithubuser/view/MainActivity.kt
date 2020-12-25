package com.example.aplikasigithubuser.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aplikasigithubuser.R
import com.example.aplikasigithubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Tambahkan MainFragment ke MainActivity
        addFragment()
    }

    private fun addFragment() {
        val fragmentManager = supportFragmentManager
        val homeFragment = MainFragment()
        val fragment = fragmentManager.findFragmentByTag(MainFragment::class.java.simpleName)
        if (fragment !is MainFragment) {
            fragmentManager
                .beginTransaction()
                .add(R.id.frame_container, homeFragment, MainFragment::class.java.simpleName)
                .commit()
        }
    }
}