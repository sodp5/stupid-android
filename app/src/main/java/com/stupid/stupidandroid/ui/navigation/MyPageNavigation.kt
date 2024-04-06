package com.stupid.stupidandroid.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.stupid.stupidandroid.ui.screen.mypage.MyPageScreen


const val myPageNavigationRoute = "mypage_route"

fun NavController.navigateToMyPage(navOptions: NavOptions? = null) {
    this.navigate(myPageNavigationRoute, navOptions)
}


fun NavGraphBuilder.myPageScreen() {
    composable(
        route = myPageNavigationRoute
    ) {
        MyPageScreen()
    }
}
