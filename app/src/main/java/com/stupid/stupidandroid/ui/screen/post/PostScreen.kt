package com.stupid.stupidandroid.ui.screen.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PostScreen(
    modifier : Modifier = Modifier,
    viewModel: PostViewModel = hiltViewModel()
) {
    PostScreen(
        modifier = modifier.fillMaxSize()
    )
}


@Composable
fun PostScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .background(Color.White),
    ) {
        PostTitleBar()
    }
}

@Preview
@Composable
private fun PostScreenPreview() {
    PostScreen(
        modifier = Modifier.fillMaxSize(),
    )
}
