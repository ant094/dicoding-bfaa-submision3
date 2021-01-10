package com.example.aplikasigithubuser.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aplikasigithubuser.model.ItemsItem
import com.example.aplikasigithubuser.repo.RepositoryUser

class ViewModelDetailUserActivity : ViewModel() {
    val repository = RepositoryUser()
    var responSuccessFollower = MutableLiveData<List<ItemsItem>>()
    var responErrorFollower = MutableLiveData<Throwable>()
    var responSuccessFollowing = MutableLiveData<List<ItemsItem>>()
    var responErrorFollowing = MutableLiveData<Throwable>()

    fun getReadFollower(username: String) {
        repository.readFollower(username, {
            responSuccessFollower.value = it
        }, {
            responErrorFollower.value = it
        })
    }

    fun getReadFollowing(username: String) {
        repository.readFollowing(username, {
            responSuccessFollowing.value = it
        }, {
            responErrorFollowing.value = it
        })
    }
}