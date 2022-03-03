package com.example.timer.viewmodel

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timer.model.Time
import com.example.timer.model.Time.formatTime

class MainViewModel: ViewModel() {

    private var countDownTimer: CountDownTimer? = null

    private val _time = MutableLiveData(Time.TIME_COUNTDOWN.formatTime())
    val time: LiveData<String> =_time

    private val _progress = MutableLiveData(1.00F)
    val progress: LiveData<Float> = _progress

    private val _isPlaying = MutableLiveData(false)
    val isPlaying: LiveData<Boolean> = _isPlaying

    fun handleCountDownTimer(){
        if (isPlaying.value == true){
            pauseTimer()
        }else{
            startTimer()
        }
    }

    private fun pauseTimer(){
        countDownTimer?.cancel()
        handleTimerValues(false,Time.TIME_COUNTDOWN.formatTime(),1.0F)
    }

    private fun startTimer(){
        _isPlaying.value = true
        countDownTimer = object : CountDownTimer(Time.TIME_COUNTDOWN,1000){
            override fun onTick(millisRemaining: Long) {
                val progressValue = millisRemaining.toFloat()/Time.TIME_COUNTDOWN
                handleTimerValues(true,millisRemaining.formatTime(),progressValue)
            }
            override fun onFinish(){
                pauseTimer()
            }
        }.start()
    }

    private fun handleTimerValues(isPlaying:Boolean,text:String,progress: Float){
        _isPlaying.value = isPlaying
        _time.value = text
        _progress.value = progress
    }
}