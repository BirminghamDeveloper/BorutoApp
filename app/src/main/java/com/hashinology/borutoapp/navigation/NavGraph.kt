package com.hashinology.borutoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.hashinology.borutoapp.utils.Constants.DETAILS_ARGUMENT_KEY
import com.hashinology.presentation.screens.home.HomeScreen
import com.hashinology.presentation.screens.splash.SplashScreen
import com.hashinology.presentation.screens.welcome.WelcomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ){
        /*composable(route = Screen.Splash.route){
            SplashScreen(navController)
        }*/
        composable(route = Screen.Welcome.route){
            WelcomeScreen({})
        }
        composable(route = Screen.Home.route){
            HomeScreen()
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY){
                type = NavType.IntType
            })
        ){

        }
        composable(route = Screen.Search.route){

        }
    }
}
