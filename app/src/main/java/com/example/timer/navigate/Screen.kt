package com.example.timer.navigate

sealed class Screen (val route:String) {
    object TimeScreen : Screen(route = "time_screen")
}
