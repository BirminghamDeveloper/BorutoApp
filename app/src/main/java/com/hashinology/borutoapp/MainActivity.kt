package com.hashinology.borutoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.annotation.ExperimentalCoilApi
import com.hashinology.borutoapp.navigation.Screen
import com.hashinology.borutoapp.navigation.SetupNavGraph
import com.hashinology.borutoapp.ui.theme.BorutoAppTheme
import com.hashinology.domain.use_cases.UseCases
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    @Inject
    lateinit var useCases: UseCases
    private val completed = mutableStateOf(false)


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch(Dispatchers.IO) {
            useCases.readOnBoardingUseCase.invoke().collect { clicked ->
                completed.value = clicked
                delay(1000)
            }
        }

        installSplashScreen()

        setContent {
            BorutoAppTheme {
                navController = rememberNavController()
                SetupNavGraph(
                    startDestination = if (completed.value) Screen.Home.route else Screen.Welcome.route,
                    navController = navController
                )
            }
        }
    }
}

