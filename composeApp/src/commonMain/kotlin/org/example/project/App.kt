package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.example.project.presentation.homeScreen.HomeScreen
import org.example.project.presentation.onboardingScreen.OnboardingScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

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

@Composable
@Preview
fun appPreview(){
    App()
}