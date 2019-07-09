package com.inlacou.library.calendar.irisratingbar

import android.os.Build

/**
 * Created by Inlacou on 31/01/2018.
 */
class IrisRatingBarCtrl(val view: IrisRatingBar, val model: IrisRatingBarMdl) {
	
	/**
	 * Updates views to their active/inactive state
	 */
	internal fun update(){
		view.valueChangeListener?.invoke(model.value)
		(0 until model.iconNumber)
				.map {
					//Map to iconItem, which contains the resource ids for active and inactive icons
					if(it>=model.icons.size){ //There we control when there are less icons than imageViews to represent, so we must repeat icons
						model.icons[it%model.icons.size]
					}else{
						model.icons[it]
					}
				}
				.forEachIndexed { index, iconItem ->
					//Now we check what do we have to draw, if active or inactive
					val newIndex = index+1 //This +1 is done to allow empty ratingBar, otherwise minimum is one icon marked
					if(model.singleSelection){
						if(newIndex==model.value){
							setAsActive(index, iconItem)
						}else{
							setAsInactive(index, iconItem)
						}
					}else if(newIndex<model.value){
						setAsActive(index, iconItem)
					}else if(newIndex==model.value){
						setAsActive(index, iconItem)
					}else{
						setAsInactive(index, iconItem)
					}
				}
	}

	private fun setAsActive(index: Int, iconItem: IrisRatingBarMdl.RatingBarItem) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			view.imageViews[index].setImageDrawable(view.resources.getDrawable(iconItem.activeResId, null))
		}else{
			view.imageViews[index].setImageDrawable(view.resources.getDrawable(iconItem.activeResId))
		}
	}

	private fun setAsInactive(index: Int, iconItem: IrisRatingBarMdl.RatingBarItem) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			view.imageViews[index].setImageDrawable(view.resources.getDrawable(iconItem.inActiveResId, null))
		}else{
			view.imageViews[index].setImageDrawable(view.resources.getDrawable(iconItem.inActiveResId))
		}
	}

	fun onActionUp() {
		view.valueSetListener?.invoke(model.value)
	}

}