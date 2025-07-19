package com.hashinology.borutoapp.navigation

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil3.annotation.ExperimentalCoilApi
import com.hashinology.borutoapp.utils.Constants.DETAILS_ARGUMENT_KEY
import com.hashinology.presentation.screens.home.HomeScreen
import com.hashinology.presentation.screens.search.SearchScreen
import com.hashinology.presentation.screens.splash.SplashScreen
import com.hashinology.presentation.screens.welcome.WelcomeScreen
import com.hashinology.presentation.screens.welcome.WelcomeViewModel

@ExperimentalMaterial3Api
@ExperimentalCoilApi
@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
){
    val welcomeVM: WelcomeViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        /*composable(route = Screen.Splash.route){
            SplashScreen(navController)
        }*/
        composable(route = Screen.Welcome.route){
            WelcomeScreen(
                onFinishButtonClick = {
                    welcomeVM.saveOnBoardingState(complete = true)
                    navController.popBackStack()
                    navController.navigate(Screen.Home.route)
                }
            )
        }
        composable(route = Screen.Home.route){
            HomeScreen(
                navController = navController
            )
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY){
                type = NavType.IntType
            })
        ){

        }
        composable(route = Screen.Search.route){
            SearchScreen(navHostController = navController)
        }
    }
}
