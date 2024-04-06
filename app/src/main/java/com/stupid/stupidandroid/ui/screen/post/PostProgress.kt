package com.stupid.stupidandroid.ui.screen.post

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.stupid.stupidandroid.R
import com.stupid.stupidandroid.ui.theme.Typography

@Composable
fun PostProgress(
    currentStep: PostProgressStep,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .drawProgressRail(currentStep),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        PostProgressStep.entries
            .filterNot { it == PostProgressStep.Finished }
            .forEach { step ->
                when {
                    step < currentStep -> DoneStep()
                    step == currentStep -> ProgressStep(step)
                    step > currentStep -> NotStartedStep(step)
                }
            }
    }
}

@Composable
private fun DoneStep() {
    Icon(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color(0xFF13C55A))
            .size(24.dp),
        painter = painterResource(id = R.drawable.icon_check_small),
        contentDescription = null,
        tint = Color.White,
    )
}

@Composable
private fun ProgressStep(step: PostProgressStep) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .border(width = 2.dp, color = Color(0xFF13C55A), shape = CircleShape)
            .background(Color.White)
            .size(24.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = step.asNumber(),
            color = Color(0xFF13C55A),
            style = Typography.XSmallSemiBold14,
        )
    }
}

@Composable
private fun NotStartedStep(step: PostProgressStep) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .background(Color(0xFFE9E9E9))
            .size(24.dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = step.asNumber(),
            color = Color(0xFF909090),
            style = Typography.XSmallSemiBold14,
        )
    }
}

private fun Modifier.drawProgressRail(currentStep: PostProgressStep): Modifier {
    return drawBehind {
        val sizeUnit = size.width / 6

        val coloredRectWidth = when (currentStep) {
            PostProgressStep.First -> sizeUnit
            PostProgressStep.Second -> sizeUnit * 3
            PostProgressStep.Third -> sizeUnit * 5
            PostProgressStep.Fourth,
            PostProgressStep.Finished -> size.width
        }

        val backgroundRectWidth = size.width - coloredRectWidth

        drawRect(
            color = Color(0xFF13C55A),
            size = size.copy(width = coloredRectWidth, height = 2.dp.toPx()),
            topLeft = Offset.Zero.copy(y = size.height / 2)
        )

        drawRect(
            color = Color(0xFFE9E9E9),
            size = size.copy(width = backgroundRectWidth, height = 2.dp.toPx()),
            topLeft = Offset.Zero.copy(x = coloredRectWidth, y = size.height / 2)
        )
    }
}

@Preview
@Composable
private fun PostProgressPreview(
    @PreviewParameter(PostProgressPreviewParameters::class) step: PostProgressStep,
) {
    PostProgress(
        currentStep = step,
    )
}

private class PostProgressPreviewParameters : PreviewParameterProvider<PostProgressStep> {
    override val values: Sequence<PostProgressStep> = PostProgressStep.entries.asSequence()
}
