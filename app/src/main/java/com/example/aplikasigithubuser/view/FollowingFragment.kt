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
import com.example.aplikasigithubuser.databinding.FragmentFollowingBinding
import com.example.aplikasigithubuser.model.Following
import com.example.aplikasigithubuser.model.ItemsItem
import com.example.aplikasigithubuser.model.TableFollowingDb
import com.example.aplikasigithubuser.viewModel.ViewModelDetailUserActivity
import java.util.ArrayList

class FollowingFragment : Fragment() {

    private var _binding: FragmentFollowingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var viewModel: ViewModelDetailUserActivity

    // This property is only valid between onCreateView and
    // onDestroyView.
    companion object {
        var username: String? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ViewModelDetailUserActivity::class.java)
        viewModel.getReadFollowing(username!!)
        observer()
    }

    private fun observer() {
        viewModel.responSuccessFollowing.observe(
            viewLifecycleOwner,
            Observer { showDataFollowingUser(it) })
        viewModel.responErrorFollowing.observe(viewLifecycleOwner, Observer {
            Toast.makeText(context, "gagal", Toast.LENGTH_SHORT).show()
        })
    }

    private fun showDataFollowingUser(it: List<ItemsItem>?) {
        if (it.isNullOrEmpty()) {
            binding.listUserFollowing.visibility = View.GONE
            binding.dataEmptyFollowing.visibility = View.VISIBLE
        } else {
            binding.listUserFollowing.visibility = View.VISIBLE
            binding.dataEmptyFollowing.visibility = View.GONE
            binding.listUserFollowing
                .adapter = FollowersAndFollowingUserAdapter(it)

            DetailUserActivity.a = it

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}