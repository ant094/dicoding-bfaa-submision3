package com.example.aplikasigithubuser.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aplikasigithubuser.model.ItemsItem
import com.example.aplikasigithubuser.model.TableFavoritDb
import com.example.aplikasigithubuser.model.TableFollowingDb
import com.example.aplikasigithubuser.repo.RepositoryUser
import com.example.aplikasigithubuser.repo.RepositoryUserDb

class ViewModelDetailUserActivity : ViewModel() {
    val repository = RepositoryUser()
    val repositoryUserDb = RepositoryUserDb()
    var responSuccessFollower = MutableLiveData<List<ItemsItem>>()
    var responErrorFollower = MutableLiveData<Throwable>()
    var responSuccessFollowing = MutableLiveData<List<ItemsItem>>()
    var responErrorFollowing = MutableLiveData<Throwable>()
    var responSuccessInsertFavorit = MutableLiveData<String>()
    var responErrorInsertFavorit = MutableLiveData<Throwable>()

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

    fun insertDataFavorit(dataFavorit: TableFavoritDb, dataFollowing: List<TableFollowingDb>) {
        repositoryUserDb.insertFavorit(
            dataFavorit, dataFollowing,
            myKanbanDatabase,
            { responSuccessInsertFavorit.value = it },
            { responErrorInsertFavorit.value = it })
    }
}