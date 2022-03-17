package com.example.timer.view.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.timer.ui.theme.mossGreen


@Composable
fun CountIndicatorCircle(
    modifier: Modifier,
    progress: Float,
    time: String,
    size: Int,
    stroke: Int
) {
    val animationProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )
    
    Column(modifier = modifier) {
        Box{

            CircularProgressIndicator(
                progress = animationProgress,
                modifier = Modifier
                    .height(size.dp)
                    .width(size.dp),
                color = mossGreen,
                strokeWidth = stroke.dp,
            )
            Column(modifier = Modifier.align(Alignment.Center)) {
                Text(
                    text = time,
                    color = Color.White,
                    fontFamily = FontFamily.Default,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }

}
