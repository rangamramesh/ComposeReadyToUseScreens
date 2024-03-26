package com.ramesh.composereadytousescreens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ramesh.composereadytousescreens.login.HomeScreen
import com.ramesh.composereadytousescreens.login.LoginScreen

@Composable
fun NavigationGraph(navigationController: NavHostController) {
    NavHost(navController = navigationController, startDestination = "login") {
        composable("login") {
            LoginScreen(onLoginSuccess = {
                navigationController.navigate("home") {
                    popUpTo(0)
                }
            })
        }
        composable("home") {
            HomeScreen()
        }
    }
}