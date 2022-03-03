package com.example.timer.view.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timer.appColor.AppColor
import java.lang.reflect.Modifier

@Composable
fun CountButton(
    modifier: Modifier,
    optionSelected: () -> Unit,
    isPlaying: Boolean
) {
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
                backgroundColor = AppColor.mossGreen,
                contentColor = AppColor.forestGreen,
            ),

            ) {
            val pair = if (!isPlaying) {
                "START"
            } else {
                "STOP"
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