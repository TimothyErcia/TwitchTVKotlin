package com.example.twitchtvkotlin.presenter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.view.marginStart
import androidx.leanback.widget.*
import com.example.twitchtvkotlin.R
import org.w3c.dom.Text

class CardPresenter() : Presenter() {
    private val TAG = "CardPresenter"
    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.row_header_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
        viewHolder?.let {
            val view = it.view
            view.findViewById<TextView>(R.id.textView1).text = item.toString()
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
        Log.i(TAG, "onUnbindViewHolder: ")
    }


}