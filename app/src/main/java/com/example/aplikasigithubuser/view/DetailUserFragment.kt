package com.example.aplikasigithubuser.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.aplikasigithubuser.databinding.FragmentDetailUserBinding
import com.example.aplikasigithubuser.model.User

class DetailUserFragment : Fragment() {
    private var _binding: FragmentDetailUserBinding? = null
    private val binding get() = _binding!!
    var getData: User? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //    Terima data dari MainActivity
        getData = arguments?.getParcelable("data")

        Glide.with(this).load(getData?.imgAvatar).into(binding.ivImg)
        binding.tvUsername.text = ": " + getData?.userName
        binding.tvName.text = ": " + getData?.Name
        binding.tvLocation.text = ": " + getData?.location
        binding.tvRepository.text = ": " + getData?.repository
        binding.tvFollowers.text = ": " + getData?.followers
        binding.tvFollowing.text = ": " + getData?.following
        binding.tvCompany.text = ": " + getData?.company

        binding.fabHome.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}