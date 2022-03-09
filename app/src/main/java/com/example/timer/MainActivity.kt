package com.example.timer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timer.Data.timeList
import com.example.timer.appColor.AppColor
import com.example.timer.model.model
import com.example.timer.model.model.formatTime
import com.example.timer.service.foregroundStartService
import com.example.timer.ui.theme.TimerTheme
import com.example.timer.view.CountDownView
import com.example.timer.view.components.CountIndicatorCircle
import com.example.timer.view.components.TimeButtons
import com.example.timer.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: MainViewModel = MainViewModel()
        super.onCreate(savedInstanceState)
        setContent {
            TimerTheme {
                val time by viewModel.time.observeAsState(model.TimeCountDown.formatTime())
                val progress by viewModel.progress.observeAsState(1.0F)
                val isPlaying by viewModel.isPlaying.observeAsState(false)

                var Notification = false
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(AppColor.forestGreen),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.padding(top = 50.dp))
                    Text(
                        text = "TIMER COUNTDOWNS",
                        style = TextStyle(
                            fontSize = 30.sp,
                            fontFamily = FontFamily.Default,
                            color = Color.White
                        )
                    )
                    TimeButtons(TimeList = timeList,viewModel)
                    CountIndicatorCircle(
                        modifier = Modifier.padding(top = 10.dp),
                        progress = progress,
                        time = time,
                        size = 320,
                        stroke = 12
                    )
                    Spacer(modifier = Modifier.height(50.dp))
                    Button(
                        onClick = {
                            if (Notification){
                                foregroundStartService("Start")
                            }
                            else
                                foregroundStartService("Exit")

                            viewModel.handleCountDownTimer()
                        },
                        modifier =
                        Modifier
                            .height(70.dp)
                            .width(200.dp),

                        shape = RoundedCornerShape(25.dp),

                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = AppColor.mossGreen,
                            contentColor = AppColor.forestGreen,
                        ),

                        ) {
                        val pair = if (!isPlaying) {
                            "Start"
                        } else {
                            "Stop"
                        }
                        Notification = pair=="Start"
                        Text(
                            pair,
                            fontSize = 20.sp,
                            color = Color.White,
                            fontFamily = FontFamily.Default
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {
                            viewModel.pauseTimer()
                        },
                        modifier =
                        Modifier
                            .height(70.dp)
                            .width(200.dp),

                        shape = RoundedCornerShape(25.dp),

                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = AppColor.mossGreen,
                            contentColor = AppColor.forestGreen,
                        ),

                        ) {
                        Text(
                            "Pause",
                            fontSize = 20.sp,
                            color = Color.White,
                            fontFamily = FontFamily.Default
                        )
                    }
                }
            }
        }
    }
}


