package com.stupid.stupidandroid.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
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
import com.stupid.stupidandroid.ui.theme.Typography

enum class TopLevelDestination(
    val selectedIcon: @Composable () -> Unit,
    val unselectedIcon: @Composable () -> Unit,
    val label: @Composable (Boolean) -> Unit,
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
        label = { selected ->
            Text(
                text = stringResource(id = R.string.main_tab_post),
                style = if (selected) {
                    Typography.XxSmallBold12
                } else {
                    Typography.XxSmallMedium12
                },
            )
        },
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
        label = { selected ->
            Text(
                text = stringResource(id = R.string.main_tab_home),
                style = if (selected) {
                    Typography.XxSmallBold12
                } else {
                    Typography.XxSmallMedium12
                },
            )
        },
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
        label = { selected ->
            Text(
                text = stringResource(id = R.string.main_tab_mypage),
                style = if (selected) {
                    Typography.XxSmallBold12
                } else {
                    Typography.XxSmallMedium12
                },
            )
        },
        route = myPageNavigationRoute
    ),
}
