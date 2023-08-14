package com.inlacou.library.ratingbar.customratingbar.ratingbars

import android.content.Context
import android.util.AttributeSet
import com.inlacou.library.irisratingbar.IrisRatingBar
import com.inlacou.library.irisratingbar.IrisRatingBarMdl
import com.inlacou.library.ratingbar.customratingbar.R

/**
 * Created by Inlacou on 31/01/2018.
 */
class StarMediumRatingBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : IrisRatingBar(context, IrisRatingBarMdl(value = 2, maxIcon = 5, minValue = 1, editable = true, singleSelection = false,
        icons = listOf(
                IrisRatingBarMdl.RatingBarItem(R.drawable.star_active_medium, R.drawable.star_not_active_medium)
        )), attrs, defStyleAttr)