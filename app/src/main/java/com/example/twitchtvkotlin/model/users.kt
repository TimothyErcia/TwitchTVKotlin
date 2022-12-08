package com.example.twitchtvkotlin.model

import android.net.Uri
import com.example.twitchtvkotlin.utility.Constants

data class Users(
    val name: String,
    val username: String,
    val password: String,
) {

    companion object {
        //USERS TABLE Constants
        val USERS_TABLE = "USERS"
        val USERS_URL = "content://" + Constants.packageName + "/UsersContentProvider/" + USERS_TABLE
        val USERS_URI = Uri.parse(USERS_URL)
        val USERS_NAME = "NAME"
        val USERS_USERNAME = "USERNAME"
        val USERS_PASSWORD = "PASSWORD"
    }
}
