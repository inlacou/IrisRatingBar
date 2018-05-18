package com.inlacou.library.calendar.irisratingbar

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout

/**
 * Created by Inlacou on 31/01/2018.
 */
open class IrisRatingBar@JvmOverloads constructor(context: Context, model: IrisRatingBarMdl? = null, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
	: FrameLayout(context, attrs, defStyleAttr) {

	var valueSetListener: ((value: Int) -> Any)? = null
	var valueChangeListener: ((value: Int) -> Any)? = null

	private var surfaceLayout: LinearLayout? = null
	internal val imageViews = mutableListOf<ImageView>()

	var model: IrisRatingBarMdl = IrisRatingBarMdl(value = 5, editable = true, singleSelection = false,
			icons = listOf(
					IrisRatingBarMdl.RatingBarItem(R.drawable.iris_star_filled, R.drawable.iris_star_empty)
					, IrisRatingBarMdl.RatingBarItem(R.drawable.iris_star_filled, R.drawable.iris_star_empty)
					, IrisRatingBarMdl.RatingBarItem(R.drawable.iris_star_filled, R.drawable.iris_star_empty)
					, IrisRatingBarMdl.RatingBarItem(R.drawable.iris_star_filled, R.drawable.iris_star_empty)
					, IrisRatingBarMdl.RatingBarItem(R.drawable.iris_star_filled, R.drawable.iris_star_empty)
			))
		set(value) {
			field = value
			populate()
		}
	//I went the extra mile and added the way to change only individual fields of the model
	var maxIcon: Int
		get() = model.maxIcon
		set(value) {
			if(model.maxIcon!=value) {
				model.maxIcon = value
				populate()
			}
		}
	var minIcon: Int
		get() = model.minIcon
		set(value) {
			if(model.minIcon!=value) {
				model.minIcon = value
				populate()
			}
		}
	var value: Int
		get() = model.value
		set(value) {
			if(model.value!=value){
				model.value = value
				controller.update()
			}
		}
	var singleSelection: Boolean
		get() = model.singleSelection
		set(value) {
			if(model.singleSelection!=value){
				model.singleSelection = value
				controller.update()
			}
		}
	var icons: List<IrisRatingBarMdl.RatingBarItem>
		get() = model.icons
		set(value) {
			if(model.icons!=value){
				model.icons = value
				controller.update()
			}
		}
	var editable: Boolean
		get() = model.editable
		set(value) {
			if(model.editable!=value){
				model.editable = value
                updateListeners()
			}
		}
	lateinit var controller: IrisRatingBarCtrl

	init {
		View.inflate(context, R.layout.view_custom_rating_bar, this)
		surfaceLayout = findViewById(R.id.view_base_layout_surface)
		attrs?.let { readAttrs(it) }
		model.let { if(it!=null) this.model = it else populate() }
	}

	private fun readAttrs(attrs: AttributeSet) {
		val ta = context.obtainStyledAttributes(attrs, R.styleable.IrisRatingBar, 0, 0)
		try {
			if (ta.hasValue(R.styleable.IrisRatingBar_editable)) {model.editable = ta.getBoolean(R.styleable.IrisRatingBar_editable, model.editable)}
			if (ta.hasValue(R.styleable.IrisRatingBar_singleSelection)) {model.singleSelection = ta.getBoolean(R.styleable.IrisRatingBar_singleSelection, model.singleSelection)}
			if (ta.hasValue(R.styleable.IrisRatingBar_value)) {model.value = ta.getInteger(R.styleable.IrisRatingBar_value, model.value)}
		} finally {
			ta.recycle()
		}
	}

	private fun populate() {
		controller = IrisRatingBarCtrl(this, this.model)
		//TODO make it compatible for model.imageViews.size!=max (I know max is not defined, but should once this is done, and be the maximum value, like minValue works)
		removeListeners()
		surfaceLayout?.removeAllViews()
		imageViews.clear()
		(0 until model.iconNumber).forEach{ addIcon() }
		controller.update()
		setListeners()
	}

	private fun addIcon(){
		val newIcon = ImageView(context)
		imageViews.add(newIcon)
		surfaceLayout?.addView(newIcon)
	}

	private fun updateListeners() {
        if(model.editable){
            setListeners()
        }else{
            removeListeners()
        }
	}

	private fun removeListeners() {
		surfaceLayout?.setOnTouchListener(null)
	}

	private fun setListeners() {
		if(model.editable){
            val touchListener = OnTouchListener { _, event ->
                val realWidth = surfaceLayout?.width ?: width
	            when {
                    event.x<=0 -> {
	                    value = model.minValue
                    }
                    event.x>=realWidth -> {
                        value = model.iconNumber
                    }
                    else -> {
                        val relativePosition = event.x
                        val maxNumber = model.iconNumber+1
                        val stepSize = realWidth/model.iconNumber
                        (model.minValue .. maxNumber)
                                .filter { currentPosition ->
	                                when (currentPosition) {
		                                model.minValue -> relativePosition < (currentPosition) * stepSize
		                                maxNumber -> relativePosition >= currentPosition * stepSize
		                                else -> relativePosition >= (currentPosition-1) * stepSize && relativePosition < (currentPosition) * stepSize
	                                }
                                }
                                .forEach { it -> value = it }
                    }
                }
                when(event.action){
                    android.view.MotionEvent.ACTION_DOWN -> {
                        attemptClaimDrag()
                        true
                    }
                    android.view.MotionEvent.ACTION_CANCEL -> false
                    android.view.MotionEvent.ACTION_UP -> {
                        controller.onActionUp()
                        false
                    }
                    android.view.MotionEvent.ACTION_MOVE -> true
                    else -> false
                }
            }
			surfaceLayout?.setOnTouchListener(touchListener)
		}else{
			surfaceLayout?.setOnTouchListener(null)
		}
	}

	override fun hasFocusable(): Boolean {
		return true
	}

	/**
	 * Tries to claim the user's drag motion, and requests disallowing any
	 * ancestors from stealing events in the drag.
	 */
	private fun attemptClaimDrag() {
		if (parent != null) {
			parent.requestDisallowInterceptTouchEvent(true)
		}
	}
}