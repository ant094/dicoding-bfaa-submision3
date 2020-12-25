package com.example.aplikasigithubuser.view

import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.aplikasigithubuser.R
import com.example.aplikasigithubuser.adapter.MainAdapter
import com.example.aplikasigithubuser.databinding.FragmentMainBinding
import com.example.aplikasigithubuser.model.User
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var dataListUser = ArrayList<User>()
    private lateinit var dataImg: TypedArray
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>

    companion object {
        private const val EXTRA_DATA = "data"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        list_user.adapter = MainAdapter(dataListUser, object : MainAdapter.OnClickListener {
            override fun detailUser(item: User?) {
                // Redirect ke detailUserFragment
                userDetail(item)
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

    private fun userDetail(item: User?) {

        val detailUserFragment = DetailUserFragment()
//        set data yang akan di kirim ke detailuserFragment
        val bundle = bundleOf("data" to item)
        detailUserFragment.arguments = bundle

        val mFragmentManager = fragmentManager
        mFragmentManager?.beginTransaction()?.apply {
            replace(
                R.id.frame_container,
                detailUserFragment,
                DetailUserFragment::class.java.simpleName
            )
            addToBackStack(null)
            commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}