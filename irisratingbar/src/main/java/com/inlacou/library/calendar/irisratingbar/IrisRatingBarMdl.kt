package com.inlacou.library.calendar.irisratingbar

/**
 * Created by Inlacou on 31/01/2018.
 */
class IrisRatingBarMdl(
		var icons: List<RatingBarItem>,
		var maxIcon: Int = 5,
		var minIcon: Int = 0,
		var minValue: Int = minIcon,
		var value: Int = minValue,
		var editable: Boolean = true,
		var singleSelection: Boolean = false
){
	var iconNumber = 0
		get() = maxIcon-minIcon

	data class RatingBarItem(
			val activeResId: Int,
			val inActiveResId: Int)
}