package com.example.timer.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

const val INTENT_COMMAND = "Command"
const val INTENT_COMMAND_EXIT = "Exit"
const val INTENT_COMMAND_REPLY = "Reply"
const val INTENT_COMMAND_ACHIEVE = "Achieve"

private const val NOTIFICATION_CHANNEL_GENERAL = "Checking"
private const val CODE_FOREGROUND_SERVICE = 1
private const val CODE_REPLY_INTENT = 2
private const val CODE_ACHIEVE_INTENT = 3

class MyService : Service(){
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

}