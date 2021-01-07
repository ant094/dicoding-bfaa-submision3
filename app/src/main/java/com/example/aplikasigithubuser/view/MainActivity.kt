package com.example.aplikasigithubuser.view

import android.content.res.TypedArray
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.aplikasigithubuser.R
import com.example.aplikasigithubuser.adapter.MainAdapter
import com.example.aplikasigithubuser.databinding.ActivityMainBinding
import com.example.aplikasigithubuser.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var dataListUser = ArrayList<User>()
    private lateinit var dataImg: TypedArray
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Tambahkan MainFragment ke MainActivity
        if (dataListUser.isNullOrEmpty()){
            // Mempersiapkan Data
            prepare()
            // Masukkan data pada array dataListUser
            addItem()
        }

//      Tampilkan Data Menggunakan adapter
        loadData()
    }

    private fun loadData() {
        binding.listUser.adapter = MainAdapter(dataListUser, object : MainAdapter.OnClickListener {
            override fun detailUser(item: User?) {
                // Redirect ke detailUserFragment
//                userDetail(item)
            }
        })
    }

    private fun prepare() {
        dataImg = resources.obtainTypedArray(R.array.avatar)
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = User(
                dataImg.getResourceId(position, -1),
                dataUsername[position],
                dataName[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position]
            )
            dataListUser.add(user)
        }

}
}