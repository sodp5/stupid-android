package com.stupid.stupidandroid.ui.screen.post

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stupid.stupidandroid.R

@Composable
fun PostTitleBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp, horizontal = 24.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .size(24.dp),
            painter = painterResource(id = R.drawable.icon_arrow_left),
            contentDescription = null,
            tint = Color.Black,
        )

        Text(
            text = stringResource(id = R.string.post_title),
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 32.sp,
                color = Color(0xff212121),
            ),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PostTitleBarPreview() {
    PostTitleBar()
}