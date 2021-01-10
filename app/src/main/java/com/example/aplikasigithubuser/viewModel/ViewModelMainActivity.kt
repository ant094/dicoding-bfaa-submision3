package com.example.aplikasigithubuser.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aplikasigithubuser.model.Response
import com.example.aplikasigithubuser.repo.RepositoryUser

class ViewModelMainActivity : ViewModel() {
    val repository = RepositoryUser()
    var responSuccessSearchUser = MutableLiveData<Response>()
    var responErrorSearchUser = MutableLiveData<Throwable>()

    fun getDataSearch(user : String) {
        repository.readSearch(user, {
            responSuccessSearchUser.value = it
        }, {
            responErrorSearchUser.value = it
        })
    }
}