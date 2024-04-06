package com.stupid.stupidandroid.ui.screen.mypage

import android.util.Log
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.stupid.stupidandroid.R
import com.stupid.stupidandroid.data.model.RemoteMyPage
import com.stupid.stupidandroid.data.model.RemoteMyPageItem
import com.stupid.stupidandroid.ui.design.component.Badge
import com.stupid.stupidandroid.ui.design.component.RewardBadge
import com.stupid.stupidandroid.ui.design.component.StableImage
import com.stupid.stupidandroid.ui.theme.Typography
import kotlinx.coroutines.launch

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier,
    viewModel: MyPageViewModel = hiltViewModel()
) {
    val selectedTab by viewModel.selectedTab.collectAsStateWithLifecycle()
    val myPage by viewModel.myPage.collectAsStateWithLifecycle()
    val badge by viewModel.badge.collectAsStateWithLifecycle()
    val postItemList by viewModel.postItemList.collectAsStateWithLifecycle()
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()

    MyPageScreen(
        myPage = myPage,
        badge = badge,
        selectedTab = selectedTab,
        listState = listState,
        postItemList = postItemList,
        isLoading = isLoading,
        onSelect = {
            viewModel.changeSelectedTab(it)
        },
        onBadgeRefresh = {
            viewModel.refreshBadge()
        },
        onClickAppName = {
            coroutineScope.launch {
                listState.animateScrollToItem(0)
            }
        },
        modifier = modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyPageScreen(
    myPage: RemoteMyPage,
    badge: Badge,
    selectedTab: MyPageTab,
    listState: LazyListState,
    postItemList: List<RemoteMyPageItem>,
    isLoading : Boolean,
    onSelect: (MyPageTab) -> Unit,
    onBadgeRefresh: () -> Unit,
    onClickAppName: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.mypage_title),
            style = Typography.SmallMedium20,
            color = Color(0xFF212121),
            modifier = Modifier
                .padding(vertical = 15.dp, horizontal = 24.dp)
                .clickable {
                    onClickAppName()
                }
        )
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(vertical = 16.dp),
            state = listState
        ) {
            item {
                ProfileImage(
                    profileImageUrl = myPage.profileImage,
                    modifier = Modifier
                        .fillMaxWidth(0.33f)
                        .clip(CircleShape)
                        .aspectRatio(1f)
                )
                Text(
                    modifier = Modifier.padding(
                        top = 10.dp,
                        bottom = 12.dp,
                    ),
                    text = "${myPage.name}! ${myPage.countAdvisedNotToBuy}번 말리고 ${myPage.countDidNotBuy}번 참았어요!",
                    style = Typography.XSmallSemiBold16,
                    color = Color(0xFF607864)
                )
                RewardBadge(
                    modifier = Modifier.padding(bottom = 24.dp, start = 12.dp, end = 12.dp),
                    colors = CardDefaults.outlinedCardColors(
                        containerColor = badge.containerColor,
                    ),
                    borderStroke = BorderStroke(1.dp, color = badge.borderColor),
                    content = badge.getRewardText(myPage),
                    contentColor = Color(0xFF607864),
                    iconResId = badge.id,
                    onBadgeRefresh = onBadgeRefresh
                )

                HorizontalDivider(
                    color = Color(0xFFE9E9E9)
                )

            }

            stickyHeader {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colorScheme.background),
                    horizontalArrangement = Arrangement.spacedBy(
                        34.dp,
                        alignment = Alignment.CenterHorizontally
                    )
                ) {
                    MyPageTab.entries.forEach {
                        MyPageTabItem(
                            title = it.id,
                            selected = it == selectedTab,
                            onSelect = {
                                onSelect(it)
                            }
                        )
                    }

                }
            }
            if(!isLoading)
            items(postItemList) {
                MyPagePostItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(2.71f)
                        .padding(start = 24.dp, end = 24.dp, top = 16.dp),
                    imageUrl = it.imageUrl,
                    title = it.title,
                    voteStatus = if (it.purchased == null) {
                        if (it.isProgressed) {
                            VoteStatus.Voting
                        } else {
                            VoteStatus.Voted
                        }
                    } else {
                        if (it.purchased == true) {
                            VoteStatus.Bought
                        } else {
                            VoteStatus.NotBought
                        }
                    },
                    voteResult = if (it.agreedCount > it.disagreedCount) {
                        VoteResult(
                            ratio = if((it.agreedCount + it.disagreedCount) == 0) 0 else (it.agreedCount * 100) / (it.agreedCount + it.disagreedCount),
                            isBuyIt = true
                        )
                    } else {
                        VoteResult(
                            ratio =if((it.agreedCount + it.disagreedCount) == 0) 0 else  (it.disagreedCount * 100) / (it.agreedCount + it.disagreedCount),
                            isBuyIt = false
                        )
                    }


                )
            }

        }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
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
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    selected: Boolean,
    onSelect: () -> Unit
) {
    Column(
        modifier = modifier
            .width(IntrinsicSize.Max)
            .padding(top = 20.dp)
            .clickable {
                onSelect()
            }
    ) {
        Text(
            stringResource(id = title),
            style = if (selected) Typography.XSmallSemiBold16.copy(fontSize = 18.sp)
            else Typography.XSmallRegular16.copy(fontSize = 18.sp),
            color = if (selected) Color(0xFF242424) else Color(0xFF989BA2)
        )
        if (selected) HorizontalDivider(color = Color(0xFF242424))
    }
}

@Composable
fun MyPagePostItem(
    imageUrl: String,
    title: String,
    voteStatus: VoteStatus,
    voteResult: VoteResult,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),

        ) {
        Row(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.27f)
            ) {
                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = imageUrl,
                    contentScale = ContentScale.FillHeight,
                    contentDescription = null
                )
                if (voteStatus in setOf(VoteStatus.Bought, VoteStatus.NotBought)) {
                    Spacer(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.White.copy(alpha = 0.6f))
                    )
                    if (voteStatus == VoteStatus.Bought) {
                        StableImage(
                            modifier = Modifier.align(Alignment.Center),
                            drawableResId = R.drawable.img_word_stupid, description = null
                        )
                    } else {
                        StableImage(
                            modifier = Modifier.align(Alignment.Center),
                            drawableResId = R.drawable.img_word_great, description = null
                        )
                    }
                }
                VoteStatusCard(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(10.dp),
                    voteStatus = voteStatus
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
                VoteCard(
                    voteResult
                )
            }
        }

    }
}

@Composable
fun VoteCard(
    voteResult: VoteResult,
) {
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
                if(voteResult.ratio != 0){
                    Spacer(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(voteResult.ratio.toFloat() / 100f)
                            .background(Color.Black)
                    )

                    Spacer(modifier = Modifier.weight((100f-voteResult.ratio.toFloat()) / 100f))
                }

            }
            Text(
                text = (if (voteResult.isBuyIt) "사라" else "사지 마라") + " ${(voteResult.ratio)}%",
                style = Typography.XSmallMedium14,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(horizontal = 12.dp)
            )
        }
    }
}

@Composable
fun VoteStatusCard(
    voteStatus: VoteStatus,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(
            containerColor = voteStatus.containerColor
        )
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 10.dp, vertical = 2.dp),
            text = stringResource(id = voteStatus.id),
            style = Typography.XxSmallMedium12,
            color = voteStatus.contentColor
        )
    }
}