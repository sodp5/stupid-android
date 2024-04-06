package com.stupid.stupidandroid.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stupid.stupidandroid.ui.screen.login.LoginScreen

const val loginNavigationRoute = "login_route"

fun NavController.navigateToLogin(navOptions: NavOptions? = null) {
    this.navigate(loginNavigationRoute, navOptions)
}


fun NavGraphBuilder.loginScreen() {
    composable(
        route = loginNavigationRoute
    ) {
        LoginScreen()
    }
}
