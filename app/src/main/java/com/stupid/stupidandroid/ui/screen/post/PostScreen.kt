package com.stupid.stupidandroid.ui.screen.post

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.stupid.stupidandroid.R
import com.stupid.stupidandroid.ui.theme.Typography
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun PostScreen(
    modifier: Modifier = Modifier,
    viewModel: PostViewModel = hiltViewModel()
) {
    val pickMedia = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = viewModel::setImageUri,
    )

    val uiState by viewModel.uiState.collectAsState()

    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    val keyboardState by keyboardAsState()

    SideEffect {
        if (keyboardState && uiState is PostUiState.Third) {
            coroutineScope.launch { scrollState.scrollTo(Int.MAX_VALUE) }
        }
    }

    PostScreen(
        modifier = modifier.fillMaxSize(),
        uiState = uiState,
        scrollState = scrollState,
        onNextStepClick = viewModel::goNextStep,
        onExplainUpdate = viewModel::setExplain,
        onReasonChange = {
            viewModel.setReason(it)
        },
        onImageUploadClick = {
            val request = PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)

            pickMedia.launch(request)
        },
    )
}

@Composable
fun PostScreen(
    uiState: PostUiState,
    scrollState: ScrollState,
    onImageUploadClick: () -> Unit,
    onExplainUpdate: (String) -> Unit,
    onReasonChange: (String) -> Unit,
    onNextStepClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .imePadding()
            .background(Color.White)
    ) {
        Column {
            PostTitleBar()

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 24.dp)
                    .padding(top = 16.dp),
            ) {
                PostProgress(
                    modifier = Modifier.padding(horizontal = 48.dp),
                    currentStep = uiState.step,
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = uiState.step.asExplain(),
                    style = Typography.XSmallSemiBold16,
                    color = Color(0xFF607864),
                )

                Spacer(modifier = Modifier.height(16.dp))

                PostStepContent(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                        .padding(bottom = 128.dp),
                    uiState = uiState,
                    onImageUploadClick = onImageUploadClick,
                    onExplainUpdate = onExplainUpdate,
                    onReasonChange = onReasonChange,
                )
            }
        }

        NextButton(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(horizontal = 24.dp)
                .padding(bottom = 24.dp)
                .fillMaxWidth(),
            onClick = onNextStepClick,
            enabled = uiState.canNext,
        )
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
            .clickable(
                enabled = enabled,
                onClick = onClick,
            )
            .background(
                color = if (enabled) Color(0xFF242424) else Color(0xFFADAFB5),
                shape = RoundedCornerShape(15.dp)
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
        uiState = PostUiState.First(),
        scrollState = ScrollState(0),
        onNextStepClick = {},
        onImageUploadClick = {},
        onExplainUpdate = {},
        onReasonChange = {},
    )
}

@Composable
fun keyboardAsState(): State<Boolean> {
    val isImeVisible = WindowInsets.ime.getBottom(LocalDensity.current) > 0
    return rememberUpdatedState(isImeVisible)
}
