package com.stupid.stupidandroid.ui.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.stupid.stupidandroid.data.model.RemotePost
import com.stupid.stupidandroid.ui.design.component.BubbleComment
import com.stupid.stupidandroid.ui.theme.Typography

@Composable
fun PostCard(
    post: RemotePost
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        PostCard(
            modifier = Modifier.fillMaxWidth(),
            imageUrl = post.imageUrl
        )

        Column(
            modifier = Modifier.offset(y = (-42).dp),
        ) {
            BubbleComment(
                comment = post.title,
            )

            Spacer(modifier = Modifier.height(10.dp))

            SubCommentBubble(
                content = post.contentFirst,
                isFromStart = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            SubCommentBubble(
                content = post.contentSecond,
                isFromStart = false
            )
        }
    }
}

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    imageUrl: String
) {
    val painter = rememberAsyncImagePainter(model = "https://qi-o.qoo10cdn.com/goods_image_big/9/0/4/5/8475369045_l.jpg")
    Box(
        modifier = modifier.padding(horizontal = 6.dp)
    ) {
        AsyncImage(
            modifier = modifier
                .fillMaxWidth()
                .height(400.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            model = imageUrl,
            error = painter,
            contentDescription = null
        )
    }
}

@Composable
fun SubCommentBubble(
    modifier: Modifier = Modifier,
    content: String,
    colors: CardColors = CardDefaults.outlinedCardColors(
        contentColor = Color(0xFFFF3385)
    ),
    borderStroke: BorderStroke = BorderStroke(1.dp, color = Color(0xFFFF3385)),
    isFromStart: Boolean = true
) {
    OutlinedCard(
        modifier = modifier,
        colors = colors.copy(
            containerColor = if (isFromStart) Color(0xFFFFEDF2) else Color(0xFFFED9E2)
        ),
        shape = RoundedCornerShape(
            topStart = if (isFromStart) 0.dp else 8.dp,
            topEnd = if (isFromStart) 8.dp else 0.dp,
            bottomStart = 8.dp,
            bottomEnd = 8.dp
        ),
        border = borderStroke
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
            text = content,
            style = Typography.XSmallMedium14
        )
    }
}
