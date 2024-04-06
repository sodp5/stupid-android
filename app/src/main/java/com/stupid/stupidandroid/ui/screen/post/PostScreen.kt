package com.stupid.stupidandroid.ui.screen.post

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PostScreen(
    modifier : Modifier = Modifier,
    viewModel: PostViewModel = hiltViewModel()
) {
    PostScreen(
        modifier = modifier
    )
}


@Composable
fun PostScreen(
    modifier: Modifier = Modifier
){
    Box {
        Text("Post")
    }
}