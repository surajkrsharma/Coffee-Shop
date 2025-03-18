package org.example.project

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.presentation.homeScreen.HomeScreen
import org.example.project.presentation.onboardingScreen.OnboardingScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "onboardingScreen"
        ) {
            composable("onboardingScreen") {
                OnboardingScreen(navController)

            }
            composable("homeScreen") {
                HomeScreen(navController)
            }
        }
    }
}
