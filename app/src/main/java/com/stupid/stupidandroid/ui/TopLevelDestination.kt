package com.stupid.stupidandroid.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.stupid.stupidandroid.R
import com.stupid.stupidandroid.ui.design.component.StableImage
import com.stupid.stupidandroid.ui.design.icon.IconPack
import com.stupid.stupidandroid.ui.design.icon.iconpack.IcHomeSelected
import com.stupid.stupidandroid.ui.design.icon.iconpack.IcHomeUnselected
import com.stupid.stupidandroid.ui.design.icon.iconpack.IcPostSelected
import com.stupid.stupidandroid.ui.design.icon.iconpack.IcPostUnselected
import com.stupid.stupidandroid.ui.navigation.homeNavigationRoute
import com.stupid.stupidandroid.ui.navigation.myPageNavigationRoute
import com.stupid.stupidandroid.ui.navigation.postNavigationRoute

enum class TopLevelDestination(
    val selectedIcon: @Composable () -> Unit,
    val unselectedIcon: @Composable () -> Unit,
    val iconTextId: Int,
    val route: String
) {
    POST(
        selectedIcon = {
            Icon(
                imageVector = IconPack.IcPostSelected,
                contentDescription = null
            )
        },
        unselectedIcon = {
            Icon(
                imageVector = IconPack.IcPostUnselected,
                contentDescription = null
            )
        },
        iconTextId = R.string.main_tab_post,
        route = postNavigationRoute
    ),
    HOME(
        selectedIcon = {
            Icon(
                imageVector = IconPack.IcHomeSelected,
                contentDescription = null
            )
        },
        unselectedIcon = {
            Icon(
                imageVector = IconPack.IcHomeUnselected,
                contentDescription = null
            )
        },
        iconTextId = R.string.main_tab_home,
        route = homeNavigationRoute
    ),
    MYPAGE(
        selectedIcon = {
            StableImage(
                modifier = Modifier.size(24.dp),
                drawableResId = R.drawable.ic_mypage_selected,
                description = null
            )
        },
        unselectedIcon = {
            StableImage(
                modifier = Modifier.size(24.dp),
                drawableResId = R.drawable.ic_mypage_unselected,
                description = null
            )
        },
        iconTextId = R.string.main_tab_mypage,
        route = myPageNavigationRoute
    ),
}