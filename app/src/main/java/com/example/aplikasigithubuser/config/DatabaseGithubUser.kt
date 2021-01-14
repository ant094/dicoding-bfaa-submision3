package com.example.aplikasigithubuser.config

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aplikasigithubuser.model.ResponseUser

@Database(entities = arrayOf(ResponseUser::class), version = 1)
abstract class DatabaseGithubUser : RoomDatabase() {
    abstract fun daoFavorit(): DaoFavorit
    companion object{
        private var INSTANCE: DatabaseGithubUser? = null
        fun getInstance(context: Context): DatabaseGithubUser? {
            if (INSTANCE == null) {
                synchronized(DatabaseGithubUser::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        DatabaseGithubUser::class.java, "dbmykanban.db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }
}