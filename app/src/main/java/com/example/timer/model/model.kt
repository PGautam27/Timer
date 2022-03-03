package com.example.timer.model

import androidx.compose.runtime.remember
import com.example.timer.model.components.DataList
import com.example.timer.model.components.timeList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import java.util.concurrent.TimeUnit

object model {
  var TimeCountDown: Long = 60000L
  val TimeObj = timeList

  fun TimeCountIncrement(id:Int){
    var i = 0
    while (i<=TimeObj.time.size){
      if (id==TimeObj.time[i].id){
        TimeCountDown = TimeObj.time[i].timeContent
      }
    }
  }
  private const val TIME_FORMAT = "%02d:%02d:%02d"

  fun Long.formatTime(): String = String.format(
    TIME_FORMAT,
    TimeUnit.MILLISECONDS.toHours(this),
    TimeUnit.MILLISECONDS.toMinutes(this),
    TimeUnit.MILLISECONDS.toSeconds(this) % 60
  )
}