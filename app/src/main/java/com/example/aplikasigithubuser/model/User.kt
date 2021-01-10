package com.example.aplikasigithubuser.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var imgAvatar: Int?, var userName: String?, var Name: String?, var location: String?,
    var repository: String?, var company: String?, var followers: String, var following: String
) : Parcelable
