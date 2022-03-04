package com.example.timer.model

import com.example.timer.Data.timeList
import java.util.concurrent.TimeUnit

object model {
  var TimeCountDown: Long = 0L
  val TimeObj = timeList

  fun TimeCountIncrement(id:Int){
    var i = 0
    while (i<TimeObj.time.size){
      if (id==TimeObj.time[i].id){
        TimeCountDown = TimeObj.time[i].timeContent
      }
      ++i
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