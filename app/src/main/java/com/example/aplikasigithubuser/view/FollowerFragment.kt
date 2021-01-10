package com.example.aplikasigithubuser.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.aplikasigithubuser.adapter.FollowersAndFollowingUserAdapter
import com.example.aplikasigithubuser.databinding.FragmentFollowerBinding
import com.example.aplikasigithubuser.model.ItemsItem
import com.example.aplikasigithubuser.viewModel.ViewModelDetailUserActivity

class FollowerFragment : Fragment() {

    private var _binding: FragmentFollowerBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: ViewModelDetailUserActivity

    companion object {
        var username: String? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ViewModelDetailUserActivity::class.java)
        viewModel.getReadFollower(username!!)
        binding.progressBar.visibility = View.VISIBLE
        observer()
    }

    private fun observer() {
        viewModel.responSuccessFollower.observe(
            viewLifecycleOwner,
            Observer { showDataFollowrUser(it) })
        viewModel.responErrorFollower.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, "gagal", Toast.LENGTH_SHORT).show()
        })
    }

    private fun showDataFollowrUser(it: List<ItemsItem>?) {
        binding.progressBar.visibility = View.INVISIBLE
        if (it.isNullOrEmpty()) {
            binding.listUserFollower.visibility = View.GONE
            binding.dataEmptyFollower.visibility = View.VISIBLE
        } else {
            binding.listUserFollower.visibility = View.VISIBLE
            binding.dataEmptyFollower.visibility = View.GONE
            binding.listUserFollower
                .adapter = FollowersAndFollowingUserAdapter(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}