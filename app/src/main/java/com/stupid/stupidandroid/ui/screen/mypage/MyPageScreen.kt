package com.stupid.stupidandroid.ui.screen.mypage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
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
import com.stupid.stupidandroid.ui.design.component.Badge
import com.stupid.stupidandroid.ui.design.component.RewardBadge
import com.stupid.stupidandroid.ui.theme.Typography

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier,
    viewModel: MyPageViewModel = hiltViewModel()
) {

    MyPageScreen(
        profile = viewModel.userProfile,
        badge = viewModel.badge,
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun MyPageScreen(
    profile: UserProfile,
    badge: Badge,
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
                top = 10.dp,
                bottom = 12.dp
            ),
            text = "${profile.name}! ${10}번 말리고 ${2}번 참았어요!",
            style = Typography.XSmallSemiBold16,
            color = Color(0xFF607864)
        )
        RewardBadge(
            modifier = Modifier.padding(bottom = 24.dp),
            colors = CardDefaults.outlinedCardColors(
                containerColor = badge.containerColor,
            ),
            borderStroke = BorderStroke(1.dp, color = badge.borderColor),
            content = "이산화탄소 배출을 20kg 줄였어요!",
            contentColor = Color(0xFF607864),
            iconResId = badge.id
        )

        HorizontalDivider(
            color = Color(0xFFE9E9E9)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                34.dp,
                alignment = Alignment.CenterHorizontally
            )
        ) {
            MyPageTabItem()
            MyPageTabItem()
        }

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp)
        ) {
            items(
                listOf(
                    1, 2, 3
                )
            ) {
                MyPagePostItem(
                    imageUrl = "https://qi-o.qoo10cdn.com/goods_image_big/9/0/4/5/8475369045_l.jpg",
                    title = "test"
                )
            }
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
fun MyPageTabItem(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.width(IntrinsicSize.Max)
    ) {
        Text("물어본거")
        HorizontalDivider()
    }
}

@Composable
fun MyPagePostItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(115.dp),
        shape = RoundedCornerShape(8.dp),

        ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.27f)
            ){
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = imageUrl,
                    contentScale = ContentScale.FillHeight,
                    contentDescription = null
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.73f)
                    .padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.spacedBy(
                    23.dp,
                    alignment = Alignment.CenterVertically
                )
            ) {
                Text(
                    text = title,
                    style = Typography.XSmallSemiBold14,
                    color = Color(0xFF607864)
                )
                VoteCard()
            }
        }

    }
}

@Composable
fun VoteCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE9E9E9)
        )

    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.5f)
                    .background(Color.Black))

                Spacer(modifier = Modifier.weight(0.5f))
            }
            Text(
                text = "사지 마라 50%",
                style = Typography.XSmallMedium14,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(horizontal = 12.dp)
            )
        }


    }
}