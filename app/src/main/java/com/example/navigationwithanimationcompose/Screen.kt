package com.example.navigationwithanimationcompose

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object ScreenOne: Screen()
    @Serializable
    data class ScreenTwo(val name: String, val surname: String): Screen()
    @Serializable
    data class ScreenThree(val title: String): Screen()
}