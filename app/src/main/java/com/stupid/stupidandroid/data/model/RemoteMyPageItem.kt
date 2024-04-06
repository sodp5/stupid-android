package com.stupid.stupidandroid.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RemoteMyPageItem(
    val id : Int = 0,
    val imageUrl : String = "",
    val title : String = "",
    val purchased : Boolean? = true,
    val isProgressed : Boolean = true,
    val agreedCount : Int = 0,
    val disagreedCount : Int = 0
)