package com.stupid.stupidandroid.ui.screen.post

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.stupid.stupidandroid.R
import com.stupid.stupidandroid.ui.theme.Typography
import kotlinx.collections.immutable.persistentListOf

private const val ExplainLengthThreshold = 17

@Composable
fun PostStepContent(
    uiState: PostUiState,
    onImageUploadClick: () -> Unit,
    onExplainUpdate: (String) -> Unit,
    onReasonChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    when (uiState) {
        is PostUiState.First -> PostImageUpload(
            modifier = modifier,
            uri = uiState.uri,
            onImageUploadClick = onImageUploadClick,
        )

        is PostUiState.Second -> PostItemExplain(
            modifier = modifier,
            uri = uiState.uri,
            explain = uiState.explain,
            onExplainUpdate = onExplainUpdate,
        )
//        PostProgressStep.Third -> PostPurchaseChoice()
//        PostProgressStep.Fourth -> PostPurchaseDoubt()
//        PostProgressStep.FourthFinally -> PostPurchaseDoubtFinally()
//        PostProgressStep.Finished -> PostPrepared()
        is PostUiState.Third -> PostReasonChoice(
            modifier = modifier,
            currentReason = uiState.currentReason,
            onReasonChange = onReasonChange,
        )
    }
}

@Composable
private fun PostImageUpload(
    uri: Uri?,
    onImageUploadClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    if (uri != null) {
        SelectedItemImage(
            modifier = modifier
                .padding(6.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable(onClick = onImageUploadClick),
            uri = uri,
        )
    } else {
        Column(
            modifier = modifier
                .padding(horizontal = 6.dp)
                .clip(RoundedCornerShape(8.dp))
                .clickable(onClick = onImageUploadClick)
                .background(
                    color = Color(0xFFE9E9E9),
                    shape = RoundedCornerShape(8.dp),
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = stringResource(id = R.string.post_step_1_content_title),
                style = Typography.XSmallMedium14,
                color = Color(0xFF989BA2),
            )

            Spacer(modifier = Modifier.height(12.dp))

            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.icon_camera_line),
                contentDescription = null,
                tint = Color(0xFF989BA2),
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = R.string.post_step_1_content_description),
                style = Typography.XSmallRegular14,
                color = Color(0xFF989BA2),
            )
        }
    }
}

@Composable
private fun PostItemExplain(
    uri: Uri,
    explain: String,
    onExplainUpdate: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val focusRequest = remember {
        FocusRequester()
    }

    LaunchedEffect(Unit) {
        focusRequest.requestFocus()
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        PostInputField(
            modifier = Modifier
                .focusRequester(focusRequest)
                .fillMaxWidth()
                .background(
                    color = Color(0xFFE9E9E9),
                    shape = RoundedCornerShape(8.dp),
                )
                .padding(horizontal = 14.dp, vertical = 12.dp),
            text = explain,
            onChange = { newValue ->
                val limitedString = if (newValue.length > ExplainLengthThreshold) {
                    newValue.substring(0, ExplainLengthThreshold)
                } else {
                    newValue
                }

                onExplainUpdate(limitedString)
            },
            textStyle = Typography.XSmallMedium14
                .copy(color = Color.Black),
            singleLine = true,
            maxLines = 1,
            placeHolder = stringResource(id = R.string.post_step_2_explain_placeholder),
            maxLength = ExplainLengthThreshold
        )

        SelectedItemImage(
            modifier = Modifier.padding(horizontal = 6.dp),
            uri = uri,
        )
    }
}

@Composable
private fun SelectedItemImage(
    uri: Uri,
    modifier: Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp)),
    ) {
        AsyncImage(
            model = uri,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
        )
    }
}

@Composable
private fun PostReasonChoice(
    currentReason: String?,
    onReasonChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val choicesSuggestionsRes = remember {
        persistentListOf(
            R.string.post_step_3_chocies_1,
            R.string.post_step_3_chocies_2,
            R.string.post_step_3_chocies_3,
        )
    }

    val (customChoice, customChoiceChange) = remember {
        mutableStateOf("")
    }

    val reasons = choicesSuggestionsRes.map { stringResource(id = it) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        reasons.forEach { reason ->
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = if (reason == currentReason) Color(0xFF13C55A) else Color(0xFFE9E9E9),
                        shape = RoundedCornerShape(8.dp),
                    )
                    .clip(RoundedCornerShape(8.dp))
                    .clickable { onReasonChange(reason) }
                    .padding(horizontal = 14.dp, vertical = 12.dp),
                text = reason,
                style = Typography.XSmallMedium14,
                color = if (reason == currentReason) Color(0xFFFFFFFF) else Color(0xFF333333),
            )
        }

        val interactionSource = remember { MutableInteractionSource() }
        val isPressed: Boolean by interactionSource.collectIsPressedAsState()

        LaunchedEffect(isPressed) {
            if (isPressed) {
                onReasonChange(customChoice)
            }
        }

        PostInputField(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = if (currentReason != null && !reasons.contains(currentReason)) Color(0xFFD0F3DE) else Color(0xFFE9E9E9),
                    shape = RoundedCornerShape(8.dp),
                )
                .padding(horizontal = 14.dp, vertical = 12.dp)
                .clip(RoundedCornerShape(8.dp)),
            text = customChoice,
            onChange = {
                onReasonChange(it)
                customChoiceChange(it)
            },
            textStyle = Typography.XSmallMedium14
                .copy(color = Color(0xFF333333)),
            interactionSource = interactionSource,
            singleLine = true,
            maxLines = 1,
            placeHolder = stringResource(id = R.string.post_step_3_custom_placeholder),
            maxLength = 29,
            decorationBottomPadding = 28.dp,
        )
    }
}

@Composable
private fun PostPurchaseDoubt() {

}

@Composable
private fun PostPurchaseDoubtFinally() {

}

@Composable
private fun PostPrepared() {

}

@Composable
private fun PostInputField(
    text: String,
    onChange: (String) -> Unit,
    placeHolder: String,
    maxLength: Int,
    textStyle: TextStyle,
    singleLine: Boolean,
    maxLines: Int,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    decorationBottomPadding: Dp = 0.dp,
) {
    BasicTextField(
        modifier = modifier,
        value = text,
        onValueChange = { newValue ->
            val limitedString = if (newValue.length > maxLength) {
                newValue.substring(0, maxLength)
            } else {
                newValue
            }

            onChange(limitedString)
        },
        textStyle = textStyle,
        singleLine = singleLine,
        maxLines = maxLines,
        interactionSource = interactionSource,
        decorationBox = { innerTextField ->
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(bottom = decorationBottomPadding)
                ) {
                    if (text.isEmpty()) {
                        Text(
                            text = placeHolder,
                            style = Typography.XSmallMedium14,
                            color = Color(0xFF989BA2),
                        )
                    }

                    innerTextField()
                }

                Text(
                    modifier = Modifier.align(Alignment.Bottom),
                    text = "${text.length}/$maxLength",
                    style = Typography.XSmallMedium14,
                    color = Color(0xFF989BA2),
                )
            }
        }
    )
}

@Preview
@Composable
private fun PostStepContentPreview() {
    Column {
        PostStepContent(
            uiState = PostUiState.First(),
            onImageUploadClick = {},
            onExplainUpdate = {},
            onReasonChange = {},
            modifier = Modifier.fillMaxSize(),
        )
    }
}
