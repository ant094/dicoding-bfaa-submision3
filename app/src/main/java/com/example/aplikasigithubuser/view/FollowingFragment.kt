package com.example.aplikasigithubuser.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aplikasigithubuser.R
import com.example.aplikasigithubuser.databinding.FragmentFollowerBinding
import com.example.aplikasigithubuser.databinding.FragmentFollowingBinding

class FollowingFragment : Fragment() {

    private var _binding: FragmentFollowingBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowingBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}