package com.stupid.stupidandroid.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RemoteMyPage(
    val memberId : Int = 0,
    val name : String = "",
    val profileImage : String= "",
    val countAdvisedNotToBuy : Int = 0,
    val countDidNotBuy : Int = 0,
    val turtleCount : Int = 0,
    val dolphinCount : Int = 0,
    val co2Count : Int = 0,
    val bulbCount : Int = 0,
    val treeCount : Int = 0,
    val waterCount : Int = 0,
    val trashCount : Int = 0
)
