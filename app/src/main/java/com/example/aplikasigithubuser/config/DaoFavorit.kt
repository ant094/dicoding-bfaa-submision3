package com.example.aplikasigithubuser.config

import androidx.room.*
import com.example.aplikasigithubuser.model.ResponseUser
import com.example.aplikasigithubuser.model.TableFavoritDb
import com.example.aplikasigithubuser.model.TableFollowingDb

@Dao
interface DaoFavorit {
//    @Query("SELECT * FROM notes WHERE position_note = :position_note")
//    fun getAllNotes(position_note : String): List<Notes>
//
    @Insert
    fun insert(userFavorit: TableFavoritDb, userFollowing : List<TableFollowingDb>)
//
//    @Update
//    fun update(notes: Notes)
//
//    @Delete
//    fun delete(notes: Notes)
}