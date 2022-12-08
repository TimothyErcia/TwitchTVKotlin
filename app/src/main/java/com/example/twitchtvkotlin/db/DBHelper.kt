package com.example.twitchtvkotlin.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.twitchtvkotlin.model.Users
import com.example.twitchtvkotlin.utility.Constants

class DBHelper(context: Context) : SQLiteOpenHelper(context, Constants.DB_Name, null, Constants.DB_Version) {
    override fun onCreate(sqlite: SQLiteDatabase) {
        sqlite.execSQL("CREATE TABLE " + Users.USERS_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, USERNAME TEXT, PASSWORD TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

}