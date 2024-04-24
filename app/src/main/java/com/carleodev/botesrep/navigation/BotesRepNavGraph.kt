package com.carleodev.botesrep.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.carleodev.botesrep.ui.ReporteDiaDestination
import com.carleodev.botesrep.ui.ReporteDiaScreen
import com.carleodev.botesrep.ui.home.AnimatedSplashScreen
import com.carleodev.botesrep.ui.home.SplashDestino

@Composable
fun BotesRepNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {

    NavHost(
        navController = navController,
        startDestination = SplashDestino.route,
        modifier = modifier
    ) {

        composable(route = SplashDestino.route) {
            AnimatedSplashScreen(
                navController = navController
            )
        }


        composable(route = ReporteDiaDestination.route) {
            ReporteDiaScreen(
                onNavigateUp = { navController.navigateUp() },
                navigateToDetalles = {}

            )
        }

    }
}