package com.example.twitchtvkotlin.presenter

import android.view.ViewGroup
import androidx.core.view.marginStart
import androidx.core.view.setPadding
import androidx.leanback.widget.*
import com.example.twitchtvkotlin.R

class CardListRowPresenter : ListRowPresenter(FocusHighlight.ZOOM_FACTOR_XSMALL) {
    override fun createRowViewHolder(parent: ViewGroup?): RowPresenter.ViewHolder {

        val view = super.createRowViewHolder(parent)
        val gridView = view.view as ListRowView
        gridView.gridView.let {
// Change selection offset
//            it.windowAlignment = BaseGridView.WINDOW_ALIGN_LOW_EDGE
//            it.windowAlignmentOffsetPercent = 0f
//            it.windowAlignmentOffset = parent?.resources?.getDimensionPixelSize(androidx.leanback.R.dimen.lb_browse_padding_start)!!
//            it.itemAlignmentOffsetPercent = 0f
            it.setItemSpacing(20)
        }

        enableChildRoundedCorners(false)
        return view
    }

    override fun isUsingDefaultListSelectEffect(): Boolean {
        return false
    }


}