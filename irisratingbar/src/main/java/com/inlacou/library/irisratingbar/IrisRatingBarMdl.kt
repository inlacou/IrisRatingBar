package com.inlacou.library.irisratingbar

/**
 * Created by Inlacou on 31/01/2018.
 */
data class IrisRatingBarMdl(
    var icons: List<RatingBarItem>,
    var maxIcon: Int = 5,
    var minIcon: Int = 0,
    var minValue: Int = minIcon,
    var value: Int = minValue,
    var editable: Boolean = true,
    var singleSelection: Boolean = false,
    var forcedIconSize: Size? = null,
){
	val iconNumber
		get() = maxIcon-minIcon

	data class RatingBarItem(
			val activeResId: Int,
			val inActiveResId: Int)
}