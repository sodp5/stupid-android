package com.stupid.stupidandroid.ui.design.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Badge
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.stupid.stupidandroid.R
import com.stupid.stupidandroid.data.model.RemoteMyPage
import com.stupid.stupidandroid.ui.design.icon.IconPack
import com.stupid.stupidandroid.ui.design.icon.iconpack.IcRefresh
import com.stupid.stupidandroid.ui.theme.Typography
import kotlin.random.Random


@Composable
fun RewardBadge(
    colors: CardColors,
    borderStroke: BorderStroke,
    @DrawableRes iconResId: Int,
    content: String,
    contentColor: Color,
    onBadgeRefresh: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = modifier,
        colors = colors,
        border = borderStroke
    ) {
        Row(
            modifier = Modifier.padding(vertical = 6.dp, horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            StableImage(
                modifier = Modifier
                    .width(16.dp)
                    .height(26.dp),
                drawableResId = iconResId,
                description = null
            )
            Text(
                modifier = Modifier.padding(horizontal = 4.dp),
                text = content,
                color = contentColor,
                style = Typography.XSmallMedium14
            )
            Icon(
                modifier = Modifier.clickable {
                    onBadgeRefresh()
                },
                imageVector = IconPack.IcRefresh, contentDescription = null
            )
        }

    }
}


enum class Badge(@DrawableRes val id: Int, val borderColor: Color, val containerColor: Color) {
    Turtle(
        R.drawable.img_turtle,
        borderColor = Color(0xFF13C55A),
        containerColor = Color(0xFFD0F3DE)
    ),
    Tree(R.drawable.img_tree, borderColor = Color(0xFF13C55A), containerColor = Color(0xFFD0F3DE)),
    Dolphin(
        R.drawable.img_turtle,
        borderColor = Color(0xFF3CB8F6),
        containerColor = Color(0xFFDCF4FF)
    ),
    Water(
        R.drawable.img_water,
        borderColor = Color(0xFF3CB8F6),
        containerColor = Color(0xFFDCF4FF)
    ),
    Fire(R.drawable.img_fire, borderColor = Color(0xFFFF7AB0), containerColor = Color(0xFFFFEDF2)),
    Bomb(R.drawable.img_bomb, borderColor = Color(0xFFFF7AB0), containerColor = Color(0xFFFFEDF2)),
    Bulb(R.drawable.img_bulb, borderColor = Color(0xFFFFC27A), containerColor = Color(0xFFFFFBED));

    fun getNextRandomBadge() : Badge {
        return Badge.entries.filter { it != this }.let {
            it[Random.nextInt(it.size)]
        }
    }

    fun getRewardText(myPage: RemoteMyPage) : String {
        return when(this){
            Turtle -> "바다거북 ${myPage.turtleCount}마리를 보호했어요!"
            Tree -> "나무 ${myPage.treeCount}그루를 심었어요!"
            Dolphin -> "돌고래 ${myPage.dolphinCount}마리의 생명을 구했어요!"
            Water -> "${myPage.waterCount}리터의 물을 절약했어요!"
            Fire -> "이산화탄 배출을 ${myPage.co2Count}Kg 줄였어요!"
            Bomb -> "비닐봉지 ${myPage.trashCount}개 분량의 쓰레기를 줄였어요!"
            Bulb -> "전구 ${myPage.bulbCount}개를 24시간 동안 켤 수 있는 에너지를 절약했어요!"
        }
    }
}