package com.stupid.stupidandroid.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation

const val mainNavigationRoute = "main_route"

fun NavController.navigateToMain(navOptions: NavOptions? = null) {
    this.navigate(mainNavigationRoute, navOptions)
}

fun NavGraphBuilder.mainScreen() {
    navigation(
        startDestination = homeNavigationRoute,
        route = mainNavigationRoute
    ) {
        postScreen()
        homeScreen()
        myPageScreen()
    }
}
