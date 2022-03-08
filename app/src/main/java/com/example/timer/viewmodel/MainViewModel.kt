package com.example.timer.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.os.CountDownTimer
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timer.model.model
import com.example.timer.model.model.formatTime
import com.example.timer.service.foregroundStartService

class MainViewModel: ViewModel() {


    private val _model = mutableStateOf<model>(model)

    private val model1 = _model.value

    private var countDownTimer: CountDownTimer? = null

    private val _time = MutableLiveData(model1.TimeCountDown.formatTime())
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


    fun changeDownTimer(id:Int){
        model1.TimeCountIncrement(id)
        countDownTimer?.cancel()
        handleTimerValues(false,model1.TimeCountDown.formatTime(),1.0F)
    }

    private fun pauseTimer(){
        countDownTimer?.cancel()
        handleTimerValues(false,model1.TimeCountDown.formatTime(),1.0F)
    }

    private fun startTimer(){
        _isPlaying.value = true
        countDownTimer = object : CountDownTimer(model1.TimeCountDown,1000){
            override fun onTick(millisRemaining: Long) {
                val progressValue = millisRemaining.toFloat()/model1.TimeCountDown
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