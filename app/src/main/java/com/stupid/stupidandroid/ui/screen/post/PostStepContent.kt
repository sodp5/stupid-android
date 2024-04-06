package com.stupid.stupidandroid.ui.screen.post

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stupid.stupidandroid.R
import com.stupid.stupidandroid.ui.theme.Typography

@Composable
fun PostStepContent(
    step: PostProgressStep,
    onImageUploadClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when (step) {
        PostProgressStep.First -> PostImageUpload(
            modifier = modifier,
            onImageUploadClick = onImageUploadClick,
        )

        PostProgressStep.Second -> PostItemExplain()
        PostProgressStep.Third -> PostPurchaseChoice()
        PostProgressStep.Fourth -> PostPurchaseDoubt()
        PostProgressStep.FourthFinally -> PostPurchaseDoubtFinally()
        PostProgressStep.Finished -> PostPrepared()
    }
}

@Composable
private fun PostImageUpload(
    onImageUploadClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
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

@Composable
private fun PostItemExplain() {

}

@Composable
private fun PostPurchaseChoice() {

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

@Preview
@Composable
private fun PostStepContentPreview() {
    PostStepContent(
        step = PostProgressStep.First,
        onImageUploadClick = {},
        modifier = Modifier.fillMaxSize(),
    )
}
