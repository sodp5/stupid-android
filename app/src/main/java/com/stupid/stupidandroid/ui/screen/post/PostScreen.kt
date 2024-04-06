package com.stupid.stupidandroid.ui.screen.post

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.stupid.stupidandroid.R
import com.stupid.stupidandroid.ui.theme.Typography

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
    currentStep: PostProgressStep,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(Color.White)
    ) {
        PostTitleBar()

        Column(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .padding(bottom = 24.dp, top = 16.dp),
        ) {
            PostProgress(
                modifier = Modifier.padding(horizontal = 48.dp),
                currentStep = currentStep,
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = currentStep.asExplain(),
                style = Typography.XSmallSemiBold16,
                color = Color(0xFF607864)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.Gray),
            )

            Spacer(modifier = Modifier.height(50.dp))

            NextButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = { },
                enabled = true,
            )
        }
    }
}

@Composable
private fun NextButton(
    onClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clickable(onClick = onClick)
            .background(
                color = if (enabled) Color(0xFF333333) else Color(0xFFADAFB5),
                shape = RoundedCornerShape(
                    topEnd = 15.dp,
                    bottomStart = 15.dp,
                    bottomEnd = 15.dp,
                )
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = Modifier.padding(vertical = 16.dp),
            text = stringResource(id = R.string.post_next),
            style = Typography.XSmallSemiBold16,
            color = Color.White,
        )
    }
}

@Preview
@Composable
private fun PostScreenPreview() {
    PostScreen(
        modifier = Modifier.fillMaxSize(),
        currentStep = PostProgressStep.Second
    )
}
