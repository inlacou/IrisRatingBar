package com.inlacou.library.ratingbar.customratingbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.inlacou.library.irisratingbar.IrisRatingBar

class MainActivity : AppCompatActivity() {

	private lateinit var rb1: IrisRatingBar

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		setSupportActionBar(findViewById(R.id.toolbar))

		rb1 = findViewById(R.id.ratingbar_1)

		rb1.valueChangeListener = {
			//Warning! pretty spammy :)
			Toast.makeText(this, "valueChanged: $it", Toast.LENGTH_SHORT).show()
		}

		findViewById<IrisRatingBar>(R.id.ratingbar_2).valueSetListener = {
			//This is the listener you will commonly use
			Toast.makeText(this, "valueSet: $it", Toast.LENGTH_SHORT).show()
		}

		findViewById<View>(R.id.btnSetRating).setOnClickListener {
			Toast.makeText(this, "Set value on first star rating bar to two", Toast.LENGTH_SHORT).show()
			rb1.model = rb1.model.copy(value = 2)
		}
	}

	override fun onCreateOptionsMenu(menu: Menu): Boolean {
		// Inflate the menu; this adds items to the action bar if it is present.
		menuInflater.inflate(R.menu.main, menu)
		return true
	}

	override fun onOptionsItemSelected(item: MenuItem): Boolean {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		return when (item.itemId) {
			R.id.action_settings -> true
			else -> super.onOptionsItemSelected(item)
		}
	}

}
