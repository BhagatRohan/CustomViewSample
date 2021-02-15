package com.rohan.customeviewsample

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rohan.customeviewsample.databinding.ItemParameterRatingBinding

class CustomCaptureParameterRatingView(context: Context, @Nullable attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private var binding: ItemParameterRatingBinding = ItemParameterRatingBinding.inflate(LayoutInflater.from(context),this,true)
    private var tvParameterName: TextView
    private var tvParameterOne: TextView
    private var tvParameterTwo: TextView
    private var tvParameterThree: TextView
    private var tvParameterFour: TextView
    private var tvParameterFive: TextView
    private var tvRating: TextView
    private var view1: View
    private var view2: View
    private var view3: View
    private var view4: View
    private var _isRated: MutableLiveData<Boolean> = MutableLiveData()
    private var isRated: LiveData<Boolean> = _isRated

    private var _rating: MutableLiveData<Int> = MutableLiveData()
    private var rating: LiveData<Int> = _rating

    init {
        tvParameterName = binding.tvParameterName
        tvParameterOne = binding.tvRateOne
        tvParameterTwo = binding.tvRateTwo
        tvParameterThree = binding.tvRateThree
        tvParameterFour = binding.tvRateFour
        tvParameterFive = binding.tvRateFive
        tvRating = binding.tvRating
        view1 = binding.view1
        view2 = binding.view2
        view3 = binding.view3
        view4 = binding.view4

        /*val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomDisplayParameterRatingView, 0, 0)

        try {
            parameterName = typedArray.getString(R.styleable.CustomDisplayParameterRatingView_parameter_name)
            parameterRating = typedArray.getString(R.styleable.CustomDisplayParameterRatingView_parameter_rating)
            rating = typedArray.getFloat(R.styleable.CustomDisplayParameterRatingView_rating, 0F)
        } finally {
            typedArray.recycle()
        }*/

        tvParameterOne.setOnClickListener {
            setText("")
            updateRatingText("1/5")
            _rating.value = 1
            setTextViewsColor(R.drawable.rating_parameter_left_yellow_background)
            setViewsColor()
        }

        tvParameterTwo.setOnClickListener {
            setText("", "")
            updateRatingText("2/5")
            _rating.value = 2
            setTextViewsColor(R.drawable.rating_parameter_left_yellow_background, "#ffe692")
            setViewsColor("#ffe692")
        }

        tvParameterThree.setOnClickListener {
            setText("", "", "")
            updateRatingText("3/5")
            _rating.value = 3
            setTextViewsColor(R.drawable.rating_parameter_left_green_background, "#94d175", "#7cb95c")
            setViewsColor("#94d175", "#7cb95c")
        }

        tvParameterFour.setOnClickListener {
            setText("", "", "", "")
            updateRatingText("4/5")
            _rating.value = 4
            setTextViewsColor(R.drawable.rating_parameter_left_green_background, "#94d175", "#7cb95c", "#519f29")
            setViewsColor("#94d175", "#7cb95c", "#519f29")
        }

        tvParameterFive.setOnClickListener {
            setText("", "", "", "", "")
            updateRatingText("5/5")
            _rating.value = 5
            setTextViewsColor(R.drawable.rating_parameter_left_green_background, "#94d175", "#7cb95c", "#519f29", R.drawable.rating_parameter_right_green_background)
            setViewsColor("#94d175", "#7cb95c", "#519f29", "#338715")
        }
    }

    private fun updateRatingText(text: String) {
        _isRated.value = true
        tvRating.visibility = View.VISIBLE
        tvRating.text = text
        //LocalBroadcastManager.getInstance(context).sendBroadcast(Intent("parameter-rating"))
    }

    private fun setText(text1: String = "1", text2: String = "2", text3: String = "3", text4: String = "4", text5: String = "5") {
        tvParameterOne.text = text1
        tvParameterTwo.text = text2
        tvParameterThree.text = text3
        tvParameterFour.text = text4
        tvParameterFive.text = text5
    }

    fun setParameterName(name: String) {
        tvParameterName.text = name
    }

    fun isRated() = isRated

    fun rating() = rating

    private fun setTextViewsColor(drawable1: Int, color2: String = "#f3f3f3", color3: String = "#f3f3f3",
                                  color4: String = "#f3f3f3", drawable2: Int = R.drawable.rating_parameter_right_grey_background) {
        tvParameterOne.background = resources.getDrawable(drawable1)
        tvParameterTwo.setBackgroundColor(Color.parseColor(color2))
        tvParameterThree.setBackgroundColor(Color.parseColor(color3))
        tvParameterFour.setBackgroundColor(Color.parseColor(color4))
        tvParameterFive.background = resources.getDrawable(drawable2)
    }

    private fun setViewsColor(color1: String = "#ffffff", color2: String = "#ffffff", color3: String = "#ffffff",
                              color4: String = "#ffffff") {
        view1.setBackgroundColor(Color.parseColor(color1))
        view2.setBackgroundColor(Color.parseColor(color2))
        view3.setBackgroundColor(Color.parseColor(color3))
        view4.setBackgroundColor(Color.parseColor(color4))
    }

    fun setParameterRating(rating: Int) {
        when (rating) {
            1 -> tvParameterOne.performClick()
            2 -> tvParameterTwo.performClick()
            3 -> tvParameterThree.performClick()
            4 -> tvParameterFour.performClick()
            5 -> tvParameterFive.performClick()
        }
    }
}