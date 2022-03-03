package com.example.timer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.timer.model.model
import com.example.timer.ui.theme.TimerTheme
import com.example.timer.view.CountDownView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TimerTheme {
                // A surface container using the 'background' color from the theme
                //modd()

                CountDownView()
            }
        }
    }
}

@Composable
fun modd() {
   /* val x: model = model()
    val X = remember {
        x.TimeObj.time
    }
    LazyColumn(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center){
        items(
            items = X,
            itemContent = {
                Text(text = it.timeContent.toString())
            }
        )
    }*/
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TimerTheme {
        Greeting("Android")
    }
}