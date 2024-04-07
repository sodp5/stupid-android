package com.stupid.stupidandroid.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RemoteUser(
    val id : Int,
    val name : String,
    val email : String? = "",
    val profileImage : String? = ""
)
