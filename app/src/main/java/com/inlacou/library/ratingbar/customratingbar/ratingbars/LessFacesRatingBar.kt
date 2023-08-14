package com.inlacou.library.ratingbar.customratingbar.ratingbars

import android.content.Context
import android.util.AttributeSet
import com.inlacou.library.irisratingbar.IrisRatingBar
import com.inlacou.library.irisratingbar.IrisRatingBarMdl
import com.inlacou.library.ratingbar.customratingbar.R

/**
 * Created by Inlacou on 31/01/2018.
 */
class LessFacesRatingBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : IrisRatingBar(context, IrisRatingBarMdl(value = 2, minValue = 0, editable = true, singleSelection = true,
        icons = listOf(
                IrisRatingBarMdl.RatingBarItem(R.drawable.face_one_active, R.drawable.face_one_not_active),
                IrisRatingBarMdl.RatingBarItem(R.drawable.face_two_active, R.drawable.face_two_not_active),
                IrisRatingBarMdl.RatingBarItem(R.drawable.face_three_active, R.drawable.face_three_not_active),
                IrisRatingBarMdl.RatingBarItem(R.drawable.face_four_active, R.drawable.face_four_not_active),
                IrisRatingBarMdl.RatingBarItem(R.drawable.face_five_active, R.drawable.face_five_not_active)
        )), attrs, defStyleAttr)