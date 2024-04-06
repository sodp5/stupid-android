package com.stupid.stupidandroid.ui.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.stupid.stupidandroid.ui.theme.Typography

@Composable
fun PostCard(
    post: RemotePost
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 40.dp, horizontal = 20.dp)
    ) {
        PostCard(
            modifier = Modifier.fillMaxWidth(),
            imageUrl = post.imageUrl
        )
        MainCommentBubble(
            modifier = Modifier.padding(top = 5.dp),
            content = post.title
        )
        SubCommentBubble(
            modifier = Modifier.padding(top = 10.dp),
            content = post.contentFirst,
            isFromStart = true
        )
        SubCommentBubble(
            modifier = Modifier.padding(top = 10.dp),
            content = post.contentFirst,
            isFromStart = false
        )

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
                .padding(bottom = 5.dp)
                .clip(RoundedCornerShape(8.dp))
                .aspectRatio(0.75f),
            contentScale = ContentScale.FillHeight,
            model = imageUrl,
            error = painter,
            contentDescription = null
        )
        Spacer(
            modifier = Modifier
                .padding(start = 1.dp)
                .width(36.dp)
                .height(18.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFE2FAE6))
                .align(Alignment.BottomStart)
        )
        Spacer(
            modifier = Modifier
                .padding(23.dp)
                .width(28.dp)
                .height(14.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFE2FAE6))
                .align(Alignment.BottomStart)
        )
    }
}

@Composable
fun MainCommentBubble(
    modifier: Modifier = Modifier,
    content: String,
    colors: CardColors = CardDefaults.cardColors(
        containerColor = Color(0xFFE2FAE6),
        contentColor = Color(0xFF607864)
    )
) {
    Card(
        modifier = modifier,
        colors = colors,
        shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 8.dp,
            bottomStart = 8.dp,
            bottomEnd = 8.dp
        )
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp),
            text = content,
            style = Typography.XSmallSemiBold16
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