package com.stupid.stupidandroid.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable


const val myPageNavigationRoute = "my_page_route"

fun NavController.navigateToMyPage(navOptions: NavOptions? = null) {
    this.navigate(myPageNavigationRoute, navOptions)
}


fun NavGraphBuilder.myPageScreen() {
    composable(
        route = myPageNavigationRoute
    ) {

    }
}
