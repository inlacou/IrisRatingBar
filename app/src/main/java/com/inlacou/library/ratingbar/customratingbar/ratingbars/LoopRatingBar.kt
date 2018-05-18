package com.inlacou.library.ratingbar.customratingbar.ratingbars

import android.content.Context
import android.util.AttributeSet
import com.inlacou.library.calendar.customratingbar.R
import com.inlacou.library.calendar.irisratingbar.IrisRatingBarMdl
import com.inlacou.library.calendar.irisratingbar.IrisRatingBar

/**
 * Created by Inlacou on 31/01/2018.
 */
class LoopRatingBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : IrisRatingBar(context, IrisRatingBarMdl(value = 2, maxIcon = 5, minValue = 3, editable = true, singleSelection = true,
        icons = listOf(
                IrisRatingBarMdl.RatingBarItem(R.drawable.face_one_active, R.drawable.face_one_not_active),
                IrisRatingBarMdl.RatingBarItem(R.drawable.face_two_active, R.drawable.face_two_not_active)
        )), attrs, defStyleAttr)