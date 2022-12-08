package com.example.twitchtvkotlin.viewmodel

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.twitchtvkotlin.model.Users

class UsersViewModel : ViewModel() {

    private var cursor: Cursor? = null
    private val getUsersArrayList: ArrayList<Users> = ArrayList()

    private val mutableUsers: MutableLiveData<List<Users>> = MutableLiveData()
    private fun getUser() : LiveData<List<Users>> = mutableUsers

    private fun initializeData(context: Context) {
        val arrayColumns = arrayOf(Users.USERS_NAME, Users.USERS_USERNAME, Users.USERS_PASSWORD)
        cursor = context?.let {
            it.contentResolver?.query(Users.USERS_URI, arrayColumns, null, null, null)
        }

        cursor?.let {
            try {
                while (it.moveToNext()) {
                    getUsersArrayList.add(Users(it.getString(1), it.getString(2), it.getString(3)))
                }
                if(it.moveToNext()) {
                    Log.i("CURSOR", it.getString(1))
                }
                mutableUsers.postValue(getUsersArrayList)
            } catch (ex: Exception) {

            }
        }

    }

    private fun insert(context: Context, users: Users) {
        val cv = ContentValues()
        cv.put(Users.USERS_USERNAME, users.username)
        cv.put(Users.USERS_NAME, users.name)
        cv.put(Users.USERS_PASSWORD, users.password)
        context?.contentResolver.insert(Users.USERS_URI, cv)
    }

    private fun updateName(context: Context, username: String, name: String) {
        val cv = ContentValues()
        cv.put(Users.USERS_USERNAME, username)
        cv.put(Users.USERS_NAME, name)

        context?.contentResolver.update(
            Users.USERS_URI,
            cv,
            Users.USERS_USERNAME + " = ? ",
            arrayOf(name)
        )
    }

    private fun updatePassword(context: Context, username: String, password: String) {
        val cv = ContentValues()
        cv.put(Users.USERS_USERNAME, username)
        cv.put(Users.USERS_PASSWORD, password)

        context?.contentResolver.update(
            Users.USERS_URI,
            cv,
            Users.USERS_USERNAME + " = ? ",
            arrayOf(password)
        )
    }

    private fun delete(context: Context, username: String) {
        context?.contentResolver.delete(
            Users.USERS_URI,
            Users.USERS_USERNAME + " = ?",
            arrayOf(username)
        )
    }


}