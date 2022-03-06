package com.example.timer.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.*
import com.example.timer.appColor.AppColor
import com.example.timer.Data.timeList
import com.example.timer.model.model
import com.example.timer.model.model.formatTime
import com.example.timer.view.components.CountButton
import com.example.timer.view.components.CountIndicatorCircle
import com.example.timer.view.components.TimeButtons
import com.example.timer.viewmodel.MainViewModel

@Composable
fun CountDownView(viewModel: MainViewModel = viewModel()) {

    val time by viewModel.time.observeAsState(model.TimeCountDown.formatTime())
    val progress by viewModel.progress.observeAsState(1.0F)
    val isPlaying by viewModel.isPlaying.observeAsState(false)

    CountDownView(time = time, progress = progress, isPlaying = isPlaying, timeList = timeList,viewModel){
        viewModel.handleCountDownTimer()
    }
}
@Composable
fun CountDownView(
    time: String,
    progress: Float,
    isPlaying: Boolean,
    timeList: timeList,
    viewModel: MainViewModel,
    function: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColor.forestGreen),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(top = 50.dp))
        Text(
            text = "TIMER COUNTDOWN",
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
        CountButton(
            modifier = Modifier
                .size(70.dp)
                .padding(50.dp),
            isPlaying = isPlaying
        ) {
            function()
        }
    }
}
