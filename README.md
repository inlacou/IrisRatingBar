# IrisRatingBar

[![](https://jitpack.io/v/inlacou/IrisRatingBar.svg)](https://jitpack.io/#inlacou/IrisRatingBar)

## Usual usage

Here we have some examples for quick access, but the project has even more. Don't be afraid to check it out!

### Faces - Single selection

In this example, we set 5 different faces to select from, with active and inactive icons for each. 

![faces single select gif](https://github.com/inlacou/IrisRatingBar/blob/master/faces_single_select.gif)

Subclass it:

```kt

import android.content.Context
import android.util.AttributeSet
import com.inlacou.library.calendar.irisratingbar.IrisRatingBar
import com.inlacou.library.calendar.irisratingbar.IrisRatingBarMdl

class FacesRatingBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : IrisRatingBar(context, IrisRatingBarMdl(value = 2, maxIcon = 5, minValue = 0, editable = true, singleSelection = true,
        icons = listOf(
                IrisRatingBarMdl.RatingBarItem(R.drawable.face_one_active, R.drawable.face_one_not_active),
                IrisRatingBarMdl.RatingBarItem(R.drawable.face_two_active, R.drawable.face_two_not_active),
                IrisRatingBarMdl.RatingBarItem(R.drawable.face_three_active, R.drawable.face_three_not_active),
                IrisRatingBarMdl.RatingBarItem(R.drawable.face_four_active, R.drawable.face_four_not_active),
                IrisRatingBarMdl.RatingBarItem(R.drawable.face_five_active, R.drawable.face_five_not_active)
        )), attrs, defStyleAttr)
```

Use it in your layouts!

```xml
<path.to.your.subclassed.ratingbar.FacesRatingBar
	android:id="@+id/ratingbar_faces"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	android:padding="16dp"/>
```

### Stars - Multiple selection

In this example all positions have the same icon, a pretty star.

![faces single select gif](https://github.com/inlacou/IrisRatingBar/blob/master/stars_multiple_selection.gif)

```kt

import android.content.Context
import android.util.AttributeSet

class StarRatingBar @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : IrisRatingBar(context, IrisRatingBarMdl(value = 2, maxIcon = 5, minValue = 0, editable = true, singleSelection = false,
        icons = listOf(
                IrisRatingBarMdl.RatingBarItem(R.drawable.star_active, R.drawable.star_not_active)
        )), attrs, defStyleAttr)
```

Use it in your layouts!

```xml
<path.to.your.subclassed.ratingbar.StarRatingBar
	android:id="@+id/ratingbar_stars"
	android:layout_width="wrap_content"
	android:layout_height="wrap_content"
	android:padding="16dp"/>
```

## Listeners

```kt
findViewById<FacesRatingBar>(R.id.ratingbar_stars).valueChangeListener = {
	//Called on every value change
	//Warning! pretty spammy :)
	Toast.makeText(this, "valueSet: $it", Toast.LENGTH_SHORT).show()
}

findViewById<StarRatingBar>(R.id.ratingbar_stars).valueSetListener = {
	//Called when user lifts it's finger, setting the value
	//This is the listener you will commonly use
	Toast.makeText(this, "valueSet: $it", Toast.LENGTH_SHORT).show()
}
```

## Parameters

* *value*: The actual value (on constructor, the starting value).
* *maxIcon*: Maximun number of icons shown. If not set, it will take the value from the size of the *icons* array. If above than *icons* size, icons will be repeated. If less, only first N icons will be used.
* *minValue*: Minimun value enabled. Mostly to allow having empty ratingbar for selecting 0 value.
* *editable*: If true, value can be modified by user.
* *singleSelection*: If true, only one icon at most will be active at any time.
* *icons*: actual icons to use.
