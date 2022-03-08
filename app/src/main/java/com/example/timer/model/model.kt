package com.example.timer.model

import android.content.Context
import android.content.Intent
import android.os.Build
import com.example.timer.Data.timeList
import com.example.timer.service.INTENT_COMMAND
import com.example.timer.service.MyService
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

  fun Context.foregroundStartService(command:String){
    val intent = Intent(this, MyService::class.java)
    if (command == "Start"){
      intent.putExtra(INTENT_COMMAND,command)

      if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
        this.startForegroundService(intent)
      }
      else{
        this.startService(intent)
      }
    }else if (command=="Exit"){
      intent.putExtra(INTENT_COMMAND,command)

      this.stopService(intent)
    }
  }
}