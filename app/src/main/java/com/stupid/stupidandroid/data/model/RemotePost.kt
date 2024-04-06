package com.stupid.stupidandroid.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RemotePost(
    val id : Int,
    val contentFirst : String,
    val contentSecond : String,
    val imageUrl : String,
    val title : String
)
