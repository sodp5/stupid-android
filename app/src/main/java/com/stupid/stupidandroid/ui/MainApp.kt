package com.stupid.stupidandroid.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.stupid.stupidandroid.R
import com.stupid.stupidandroid.ui.design.component.MainNavigationBar
import com.stupid.stupidandroid.ui.design.component.MainNavigationBarItem
import com.stupid.stupidandroid.ui.design.component.StableImage
import com.stupid.stupidandroid.ui.navigation.navigateToHome
import com.stupid.stupidandroid.ui.navigation.navigateToMyPage
import com.stupid.stupidandroid.ui.navigation.navigateToPost
import com.stupid.stupidandroid.ui.screen.home.Choice
import kotlinx.coroutines.delay

@Composable
fun MainApp() {
    val navController = rememberNavController()
    var shownEventScreen by remember {
        mutableStateOf<Choice?>(null)
    }

    LaunchedEffect(shownEventScreen) {
        if(shownEventScreen != null){
            delay(500)
            shownEventScreen = null
        }
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            bottomBar = {
                MainBottomBar(
                    destinations = TopLevelDestination.entries,
                    currentDestination = navController.currentBackStackEntryAsState().value?.destination,
                    onNavigateToDestination = {
                        val navOptions = navOptions {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        when (it) {
                            TopLevelDestination.HOME -> navController.navigateToHome(navOptions)
                            TopLevelDestination.POST -> navController.navigateToPost(navOptions)
                            TopLevelDestination.MYPAGE -> navController.navigateToMyPage(navOptions)
                        }
                    }
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues)
            ) {
                MainNavHost(
                    onShowEventScreen = {
                        shownEventScreen = it
                    },
                    navController = navController

                )
            }
        }

        val scaleAnimate by animateFloatAsState(
            targetValue = if (shownEventScreen != null) {
                1f
            } else {
                0.5f
            },
            label = "scale"
        )

        val alphaAnimate by animateFloatAsState(
            targetValue = if (shownEventScreen != null) {
                1f
            } else {
                0.6f
            },
            label = "alpha"
        )

        if (shownEventScreen is Choice.BuyIt) {
            StableImage(
                modifier = Modifier
                    .scale(scaleAnimate)
                    .alpha(alphaAnimate)
                    .fillMaxSize()
                    .background(color = Color(0xCCFFFFFF)),
                drawableResId = R.drawable.img_buy_it,
                contentScale = ContentScale.FillWidth,
                description = null
            )

        } else if (shownEventScreen is Choice.Stupid) {
            StableImage(
                modifier = Modifier
                    .scale(scaleAnimate)
                    .alpha(alphaAnimate)
                    .fillMaxSize()
                    .background(color = Color(0x78D2E7E0)),
                drawableResId = R.drawable.img_stupid,
                contentScale = ContentScale.FillWidth,
                description = null
            )
        }
    }

}

@Composable
fun MainBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    MainNavigationBar(
        modifier = modifier,
        containerColor = Color.White
    ) {
        destinations.forEach { destination ->
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            MainNavigationBarItem(
                selected = selected,
                onClick = {
                    onNavigateToDestination(destination)
                },
                icon = destination.unselectedIcon,
                label = { destination.label(selected) },
                selectedIcon = destination.selectedIcon
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
