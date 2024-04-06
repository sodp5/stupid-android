package com.stupid.stupidandroid.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.stupid.stupidandroid.ui.navigation.loginNavigationRoute
import com.stupid.stupidandroid.ui.navigation.loginScreen
import com.stupid.stupidandroid.ui.navigation.mainNavigationRoute
import com.stupid.stupidandroid.ui.navigation.mainScreen
import com.stupid.stupidandroid.ui.navigation.navigateToHome
import com.stupid.stupidandroid.ui.screen.home.Choice

@Composable
fun MainNavHost(
    navController: NavHostController,
    onShowEventScreen : (Choice) -> Unit,
    modifier : Modifier = Modifier,

    ) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = mainNavigationRoute
    ) {
        mainScreen(
            onNavigateHome = { navController.navigateToHome() },
            onShowEventScreen = onShowEventScreen
        )
        loginScreen()
    }
}
