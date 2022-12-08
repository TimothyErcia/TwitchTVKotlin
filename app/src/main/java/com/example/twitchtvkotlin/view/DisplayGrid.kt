package com.example.twitchtvkotlin.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.motion.widget.MotionScene
import androidx.core.view.marginStart
import androidx.leanback.app.RowsSupportFragment
import androidx.leanback.app.VerticalGridSupportFragment
import androidx.leanback.widget.*
import com.example.twitchtvkotlin.presenter.CardListRowPresenter
import com.example.twitchtvkotlin.presenter.CardPresenter

class DisplayGrid : RowsSupportFragment() {
    private val TAG = "DisplayGrid"
    private lateinit var _context: Context

    private val mAdapter: ArrayObjectAdapter = ArrayObjectAdapter(CardListRowPresenter())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _context = requireContext()
        loadData()
        adapter = mAdapter
    }

    private fun loadData() {
        val header = HeaderItem("Header 1")
        val array = ArrayObjectAdapter(CardPresenter())
        array.add("ITEM 1")
        array.add("ITEM 2")
        array.add("ITEM 3")
        array.add("ITEM 4")
        array.add("ITEM 5")
        array.add("ITEM 6")

        mAdapter.add(ListRow(header, array))
        mAdapter.add(ListRow(null, array))
        mAdapter.add(ListRow(header, array))
        mAdapter.add(ListRow(null, array))
    }
}