package com.inlacou.library.ratingbar.customratingbar.ratingbars

import android.content.Context
import android.util.AttributeSet
import com.inlacou.library.calendar.customratingbar.R
import com.inlacou.library.calendar.irisratingbar.IrisRatingBarMdl
import com.inlacou.library.calendar.irisratingbar.IrisRatingBar

/**
 * Created by Inlacou on 31/01/2018.
 */
class StarSmallRatingBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : IrisRatingBar(context, IrisRatingBarMdl(value = 2, maxIcon = 5, minValue = 0, editable = true, singleSelection = false,
        icons = listOf(
                IrisRatingBarMdl.RatingBarItem(R.drawable.star_active_small, R.drawable.star_not_active_small)
        )), attrs, defStyleAttr)