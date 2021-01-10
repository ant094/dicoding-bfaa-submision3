package com.example.aplikasigithubuser.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aplikasigithubuser.model.ResponseSearchUser
import com.example.aplikasigithubuser.model.ResponseUser
import com.example.aplikasigithubuser.repo.RepositoryUser

class ViewModelMainActivity : ViewModel() {
    val repository = RepositoryUser()
    var responSuccessSearchUser = MutableLiveData<ResponseSearchUser>()
    var responErrorSearchUser = MutableLiveData<Throwable>()
    var responSuccessDetailUser = MutableLiveData<ResponseUser>()
    var responErrorDetailUser = MutableLiveData<Throwable>()

    fun getDataSearch(user: String) {
        repository.readSearch(user, {
            responSuccessSearchUser.value = it
        }, {
            responErrorSearchUser.value = it
        })
    }

    fun getDataDetail(user: String) {
        repository.readDetail(user, {
            responSuccessDetailUser.value = it
        }, {
            responErrorDetailUser.value = it
        })
    }
}