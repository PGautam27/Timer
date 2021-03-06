package com.example.timer.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timer.ui.theme.forestGreen
import com.example.timer.ui.theme.mossGreen

@Composable
fun CountButton(
    modifier: androidx.compose.ui.Modifier,
    isPlaying: Boolean,
    optionSelected: () -> Unit,
) {
    var x = remember {
        "Start"
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 90.dp)
    ) {

        Button(
            onClick = {
                optionSelected()
            },
            modifier =
            androidx.compose.ui.Modifier
                .height(70.dp)
                .width(200.dp),

            shape = RoundedCornerShape(25.dp),

            colors = ButtonDefaults.buttonColors(
                backgroundColor = mossGreen,
                contentColor = forestGreen,
            ),

            ) {
            val pair = if (!isPlaying) {
                "Start"
            } else {
                "Stop"
            }
            Text(
                pair,
                fontSize = 20.sp,
                color = Color.White,
                fontFamily = FontFamily.Default
            )
        }
    }
}

