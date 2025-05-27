package com.hashinology.domain.model

import androidx.annotation.DrawableRes
import com.hashinology.borutoapp.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String
) {
    data object First: OnBoardingPage(
        image = R.drawable.greetings,
        title = "Greeting",
        description = "Are you a Boruto fan? Because if you are then we have a great news for you!"
    )
    data object Second: OnBoardingPage(
        image = R.drawable.explore,
        title = "Explorer",
        description = "Find your favorite heroes and learn some of the things that you didn't know about."
    )
    data object Third: OnBoardingPage(
        image = R.drawable.power,
        title = "Power",
        description = "Check out your hero's power and  see how much are they strong comparing to others."
    )
}