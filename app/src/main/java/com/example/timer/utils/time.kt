package com.example.timer.utils

import java.util.concurrent.TimeUnit

object Time {
    const val TIME_COUNTDOWN: Long = 600000L
    private const val TIME_FORMAT = "%02d:%02d:%02d"

    fun Long.formatTime(): String = String.format(
        TIME_FORMAT,
        TimeUnit.MILLISECONDS.toHours(this),
        TimeUnit.MILLISECONDS.toMinutes(this),
        TimeUnit.MILLISECONDS.toSeconds(this)
    )
}