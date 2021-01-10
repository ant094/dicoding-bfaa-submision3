package com.example.aplikasigithubuser.view

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.aplikasigithubuser.R
import com.example.aplikasigithubuser.adapter.MainAdapter
import com.example.aplikasigithubuser.adapter.SearchUserAdapter
import com.example.aplikasigithubuser.databinding.ActivityMainBinding
import com.example.aplikasigithubuser.model.ItemsItem
import com.example.aplikasigithubuser.model.Response
import com.example.aplikasigithubuser.model.User
import com.example.aplikasigithubuser.viewModel.ViewModelMainActivity

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

    lateinit var viewModel: ViewModelMainActivity

    companion object {
        val EXTRA_DATA_USER = "data_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProviders.of(this).get(ViewModelMainActivity::class.java)

//        Tambahkan MainFragment ke MainActivity
        if (dataListUser.isNullOrEmpty()) {
            // Mempersiapkan Data
            prepare()
            // Masukkan data pada array dataListUser
            addItem()
        }

        observer()
//      Tampilkan Data Menggunakan adapter
        loadData()
    }

    private fun observer() {
        viewModel.responSuccessSearchUser.observe(this, Observer { showDataSearchUser(it) })
        viewModel.responErrorSearchUser.observe(this, Observer {
            Toast.makeText(this, "gagal", Toast.LENGTH_SHORT).show()
        })
    }

    private fun showDataSearchUser(it: Response?) {
        binding.listUser.adapter =
            SearchUserAdapter(it?.items, object : SearchUserAdapter.OnClickListener {
                override fun detailSearchUser(item: ItemsItem?) {

              val intent = Intent(this@MainActivity, DetailSearchUserActivity::class.java)
              intent.putExtra(EXTRA_DATA_USER, item)
              startActivity(intent)
                }
            })
    }

    private fun loadData() {
        binding.listUser.adapter = MainAdapter(dataListUser, object : MainAdapter.OnClickListener {
            override fun detailUser(item: User?) {
                // Redirect ke detailUserFragment
                val intent = Intent(this@MainActivity, DetailUserActivity::class.java)
                intent.putExtra(EXTRA_DATA_USER, item)
                startActivity(intent)
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.option_menu, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu?.findItem(R.id.search)?.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.queryHint = resources.getString(R.string.search_hint)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.getDataSearch(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
        return true
    }

}