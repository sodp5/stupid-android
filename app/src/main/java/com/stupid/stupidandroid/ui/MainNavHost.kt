package com.stupid.stupidandroid.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.stupid.stupidandroid.ui.navigation.loginScreen
import com.stupid.stupidandroid.ui.navigation.mainNavigationRoute
import com.stupid.stupidandroid.ui.navigation.mainScreen

@Composable
fun MainNavHost(
    modifier : Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = mainNavigationRoute
    ) {
        mainScreen()
        loginScreen()
    }
}