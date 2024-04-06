package com.stupid.stupidandroid.ui.screen.mypage

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MyPageScreen(
    modifier : Modifier = Modifier,
    viewModel: MyPageViewModel = hiltViewModel()
) {
    MyPageScreen(
        modifier = modifier
    )
}

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier
){
    Box {
        Text("MyPage")
    }
}