package com.rohan.customeviewsample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import com.rohan.customeviewsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var areParameterRatingSelected = BooleanArray(4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        binding.layoutParameterRating.layoutParameterOne.setParameterName("Picture")
        binding.layoutParameterRating.layoutParameterTwo.setParameterName("Sound")
        binding.layoutParameterRating.layoutParameterThree.setParameterName("Delivery and Installation")
        binding.layoutParameterRating.layoutParameterFour.setParameterName("Value for Money")

        binding.layoutParameterRating.tvSubmit.isEnabled = false

        binding.layoutParameterRating.layoutParameterOne.isRated().observe(this, { isRated ->
            if (isRated) {
                areParameterRatingSelected[0] = isRated
                updateParameterRatingSubmitButton()
            }
        })

        binding.layoutParameterRating.layoutParameterTwo.isRated().observe(this, { isRated ->
            if (isRated) {
                areParameterRatingSelected[1] = isRated
                updateParameterRatingSubmitButton()
            }
        })

        binding.layoutParameterRating.layoutParameterThree.isRated().observe(this, { isRated ->
            if (isRated) {
                areParameterRatingSelected[2] = isRated
                updateParameterRatingSubmitButton()
            }
        })

        binding.layoutParameterRating.layoutParameterFour.isRated().observe(this, { isRated ->
            if (isRated) {
                areParameterRatingSelected[3] = isRated
                updateParameterRatingSubmitButton()
            }
        })

        binding.layoutParameterRating.tvSubmit.setOnClickListener {
            Toast.makeText(this, "Submit Clicked", Toast.LENGTH_SHORT).show()
        }

        binding.layoutParameterRating.tvSkip.setOnClickListener {
            Toast.makeText(this, "Skip Clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateParameterRatingSubmitButton() {

        val isAllTrue: (Boolean) -> Boolean = { it }

        if (areParameterRatingSelected.all(isAllTrue)) {
            binding.layoutParameterRating.tvSubmit.isEnabled = true
            binding.layoutParameterRating.tvSubmit.background = ResourcesCompat.getDrawable(resources, R.drawable.border_button_pink, null)
            binding.layoutParameterRating.tvSubmit.setTextColor(Color.parseColor("#DA1C5C"))
        }
    }
}