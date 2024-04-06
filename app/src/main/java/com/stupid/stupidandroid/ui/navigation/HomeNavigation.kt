package com.stupid.stupidandroid.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stupid.stupidandroid.ui.screen.home.Choice
import com.stupid.stupidandroid.ui.screen.home.HomeScreen


const val homeNavigationRoute = "home_route"

fun NavController.navigateToHome(navOptions: NavOptions? = null) {
    this.navigate(homeNavigationRoute, navOptions)
}


fun NavGraphBuilder.homeScreen(
    onShowEventScreen : (Choice) -> Unit,
) {
    composable(
        route = homeNavigationRoute
    ) {
        HomeScreen(
            onShowEventScreen = onShowEventScreen
        )
    }
}
