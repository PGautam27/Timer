package com.example.timer.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.timer.viewmodel.MainViewModel
import androidx.lifecycle.viewmodel.compose.*
import com.example.timer.utils.Time
import com.example.timer.utils.Time.formatTime
import com.example.timer.view.components.CountButton
import com.example.timer.view.components.CountIndicatorCircle

@Composable
fun CountDownView(viewModel: MainViewModel = viewModel()) {
    val time by viewModel.time.observeAsState(Time.TIME_COUNTDOWN.formatTime())
    val progress by viewModel.progress.observeAsState(1.0F)
    val isPlaying by viewModel.isPlaying.observeAsState(false)

    CountDownView(time = time, progress = progress, isPlaying = isPlaying) {
        viewModel.handleCountDownTimer()
    }
}

@Composable
fun CountDownView(
    time:String,
    progress: Float,
    isPlaying: Boolean,
    optionSelected: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CountIndicatorCircle(
            modifier = Modifier.padding(top = 50.dp),
            progress = progress,
            time = time,
            size = 320,
            stroke = 12
        )
        CountButton(
            modifier = Modifier
                .size(70.dp)
                .padding(50.dp),
            optionSelected = { optionSelected },
            isPlaying = isPlaying
        )
    }
}