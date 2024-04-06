package com.stupid.stupidandroid.ui.screen.post

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PostScreen(
    modifier: Modifier = Modifier,
    viewModel: PostViewModel = hiltViewModel()
) {
    PostScreen(
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun PostScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.background(Color.White),
    ) {
        PostTitleBar()

        Spacer(modifier = Modifier.height(16.dp))

        PostProgress(
            modifier = Modifier.padding(horizontal = 72.dp),
            currentStep = PostProgressStep.Second,
        )
    }
}

@Preview
@Composable
private fun PostScreenPreview() {
    PostScreen(
        modifier = Modifier.fillMaxSize(),
    )
}
