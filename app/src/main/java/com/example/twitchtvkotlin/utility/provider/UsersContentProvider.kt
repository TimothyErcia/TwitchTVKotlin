package com.example.twitchtvkotlin.utility.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import com.example.twitchtvkotlin.db.DBHelper
import com.example.twitchtvkotlin.model.Users

class UsersContentProvider : ContentProvider() {

    private var helper: DBHelper? = null
    private var db: SQLiteDatabase? = null

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?): Int {
        val count = db?.delete(Users.USERS_TABLE, selection, selectionArgs)
        context?.contentResolver?.notifyChange(uri, null)
        return count ?: 0
    }

    override fun getType(uri: Uri): String? {
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        db?.insert(Users.USERS_TABLE, null, values)
        context?.contentResolver?.notifyChange(uri, null)
        return uri
    }

    override fun onCreate(): Boolean {
        helper = context?.let { DBHelper(it) }
        db = helper?.writableDatabase
        if(db != null) {
            return true
        }
        return false
    }

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ): Cursor? {
        return db?.query(Users.USERS_TABLE, projection, selection, selectionArgs, null, null, sortOrder)
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ): Int {
        val count = db?.update(Users.USERS_TABLE, values, selection, selectionArgs)
        context?.contentResolver?.notifyChange(uri, null)
        return count ?: 0
    }
}