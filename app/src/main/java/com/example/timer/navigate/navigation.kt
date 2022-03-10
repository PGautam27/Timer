package com.example.timer.navigate

import android.app.PendingIntent
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.timer.MainActivity

@Composable
fun navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = Screen.TimeScreen.route){
        composable(Screen.TimeScreen.route){
            MainActivity()
        }
    }
}