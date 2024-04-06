package com.stupid.stupidandroid.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.stupid.stupidandroid.ui.design.component.MainNavigationBar
import com.stupid.stupidandroid.ui.design.component.MainNavigationBarItem
import com.stupid.stupidandroid.ui.navigation.navigateToHome
import com.stupid.stupidandroid.ui.navigation.navigateToMyPage
import com.stupid.stupidandroid.ui.navigation.navigateToPost

@Composable
fun MainApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            MainBottomBar(
                destinations = TopLevelDestination.entries,
                currentDestination = navController.currentBackStackEntryAsState().value?.destination,
                onNavigateToDestination = {
                    when(it){
                        TopLevelDestination.HOME -> navController.navigateToHome()
                        TopLevelDestination.POST -> navController.navigateToPost()
                        TopLevelDestination.MYPAGE -> navController.navigateToMyPage()
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            MainNavHost(navController = navController)
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
                selectedIcon = destination.selectedIcon
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false