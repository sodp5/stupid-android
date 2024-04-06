package com.stupid.stupidandroid.ui.screen.home

data class ItemModel(
    val id : Int,
    val imageUrl : String,
    val mainComment : String,
    val subCommentList : List<String>
)