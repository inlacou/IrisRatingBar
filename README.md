# IrisRatingBar

[![](https://jitpack.io/v/inlacou/IrisRatingBar.svg)](https://jitpack.io/#inlacou/IrisRatingBar)

## Usual usage

Subclass it:

```kt

import android.content.Context
import android.util.AttributeSet

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

//TODO add more usage examples here.
