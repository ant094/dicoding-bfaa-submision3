package com.example.aplikasigithubuser.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.aplikasigithubuser.adapter.FollowersUserAdapter
import com.example.aplikasigithubuser.databinding.FragmentHomeBinding
import com.example.aplikasigithubuser.model.ItemsItem
import com.example.aplikasigithubuser.viewModel.ViewModelDetailUserActivity

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    lateinit var viewModel: ViewModelDetailUserActivity
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view

}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProviders.of(this).get(ViewModelDetailUserActivity::class.java)
//        viewModel.getReadFollower("sidiqpermana")
//        observer()
    }

    private fun observer() {
//        viewModel.responSuccessFollower.observe(viewLifecycleOwner, Observer {  showDataFollowerUser(it) })
//        viewModel.responErrorFollower.observe(viewLifecycleOwner, Observer {
//            Toast.makeText(context, "gagal", Toast.LENGTH_SHORT).show()
//        })
    }

//    private fun showDataFollowerUser(it: List<ItemsItem>?) {
//        binding.listUser2
//            .adapter = FollowersUserAdapter(it, object : FollowersUserAdapter.OnClickListener {
//
//            override fun detailSearchUser(item: ItemsItem?) {
//                TODO("Not yet implemented")
//            }
//        })
//    }


}