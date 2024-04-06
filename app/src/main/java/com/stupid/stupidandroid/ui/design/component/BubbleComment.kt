package com.stupid.stupidandroid.ui.design.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stupid.stupidandroid.ui.theme.Typography

@Composable
fun BubbleComment(
    comment: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        Box(
            modifier = Modifier
                .offset(x = 29.dp)
                .width(28.dp)
                .height(18.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFE2FAE6))
        )

        Box(
            modifier = Modifier
                .offset(x = 7.dp)
                .width(36.dp)
                .height(18.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFE2FAE6))
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFE2FAE6),
                    shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 8.dp,
                        bottomEnd = 8.dp,
                        bottomStart = 8.dp
                    )
                )
                .padding(horizontal = 16.dp, vertical = 10.dp),
            text = comment,
            color = Color(0xFF607864),
            style = Typography.XSmallSemiBold16,
        )
    }
}

@Preview
@Composable
fun BubbleCommentPreview() {
    BubbleComment("귀여운 고양이 이어폰 거치대ㅠㅠ 살까 말까?")
}
