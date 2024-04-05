package com.stupid.stupidandroid.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable


const val postNavigationRoute = "post_route"

fun NavController.navigateToPost(navOptions: NavOptions? = null) {
    this.navigate(postNavigationRoute, navOptions)
}


fun NavGraphBuilder.postScreen() {
    composable(
        route = postNavigationRoute
    ) {

    }
}
