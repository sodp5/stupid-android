package com.stupid.stupidandroid.ui.screen.home.state

import com.stupid.stupidandroid.data.model.RemotePost

data class HomeUiState(
    val isLoading : Boolean = false,
    val isEnded : Boolean = false,
    val postList : List<RemotePost> = emptyList()
)
