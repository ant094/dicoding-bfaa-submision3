package com.example.aplikasigithubuser.repo

import com.example.aplikasigithubuser.config.DatabaseGithubUser
import com.example.aplikasigithubuser.model.ResponseUser
import com.example.aplikasigithubuser.model.TableFavoritDb
import com.example.aplikasigithubuser.model.TableFollowingDb
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class RepositoryUserDb {
    fun insertFavorit(dataFavorit: TableFavoritDb, dataFollowingDb: List<TableFollowingDb>,myKanbanDatabase : DatabaseGithubUser, responHandler: (String) -> Unit, errorHandler: (Throwable) -> Unit) {

        Observable.fromCallable { myKanbanDatabase.daoFavorit().insert(dataFavorit, dataFollowingDb) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler("sukses")
            },{
                errorHandler(it)
            })
    }
}