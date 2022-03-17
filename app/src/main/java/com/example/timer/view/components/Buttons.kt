package com.example.timer.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.timer.Data.timeList
import com.example.timer.ui.theme.mossGreen
import com.example.timer.viewmodel.MainViewModel

@Composable
fun TimeButtons(
TimeList: timeList,
viewModel: MainViewModel
) {
    val times = remember { TimeList.time }
    LazyRow(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        items(
            items = times,
            itemContent = {
                Spacer(modifier = Modifier.padding(start = 10.dp))
                Button(
                    onClick = { viewModel.changeDownTimer(it.id) },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = mossGreen,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .height(50.dp)
                        .width(100.dp)
                ) {
                    Text(text = it.value)
                }
                Spacer(modifier = Modifier.padding(10.dp))
            }
        )
    }
}

