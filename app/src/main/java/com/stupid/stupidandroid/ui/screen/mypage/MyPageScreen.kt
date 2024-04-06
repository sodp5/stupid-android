package com.stupid.stupidandroid.ui.screen.mypage

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.stupid.stupidandroid.ui.design.component.StableImage
import com.stupid.stupidandroid.ui.theme.Typography

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier,
    viewModel: MyPageViewModel = hiltViewModel()
) {

    MyPageScreen(
        profile = viewModel.userProfile,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun MyPageScreen(
    profile: UserProfile,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileImage(
            profileImageUrl = profile.imageUrl,
            modifier = Modifier
                .fillMaxWidth(0.33f)
                .clip(CircleShape)
                .aspectRatio(1f)
        )

        Text(
            modifier = Modifier.padding(
                top = 10.dp
            ),
            text = profile.name,
            style = Typography.XSmallSemiBold16,
            color = Color(0xFF607864)
        )

        LazyRow(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(24.dp)
        ) {

        }
    }
}

@Composable
fun ProfileImage(
    profileImageUrl: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop
) {
    AsyncImage(
        modifier = modifier,
        model = profileImageUrl,
        contentScale = contentScale,
        contentDescription = null
    )
}

@Composable
fun RewardBadge(
    colors: CardColors,
    borderStroke: BorderStroke,
    @DrawableRes iconUrl: Int,
    content: String,
    contentColor: Color
) {
    OutlinedCard(
        colors = colors,
        border = borderStroke
    ) {
        Row(
            modifier = Modifier.padding(vertical = 6.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.Top
        ) {
            StableImage(drawableResId = iconUrl, description = null)
            Text(
                text = content,
                color = contentColor,
                style = Typography.XxSmallMedium12
            )
        }

    }
}