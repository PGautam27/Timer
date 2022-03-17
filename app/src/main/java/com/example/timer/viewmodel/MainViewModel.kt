package com.example.timer.viewmodel

import android.os.CountDownTimer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timer.model.model
import com.example.timer.model.model.formatTime
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel: ViewModel() {
    private val _model = mutableStateOf<model>(model)

    private val model1 = _model.value

    private var progressValue1 = 0.0F
    private var milli = 0L

    private var countDownTimer: CountDownTimer? = null

    private val _time = MutableStateFlow(model1.TimeCountDown.formatTime())
    val time =_time.asStateFlow()

    private val _progress = MutableStateFlow(1.00F)
    val progress= _progress.asStateFlow()

    private val _isPlaying = MutableStateFlow(false)
    val isPlaying= _isPlaying.asStateFlow()

    private val _wannaPause = MutableLiveData(false)
    var wannaPause: LiveData<Boolean> = _wannaPause

    fun handleCountDownTimer(){
        if (isPlaying.value){
            stopTimer()
        }
        else{
            startTimer()
        }
    }


    fun changeDownTimer(id:Int){
        model1.TimeCountIncrement(id)
        countDownTimer?.cancel()
        handleTimerValues(false,model1.TimeCountDown.formatTime(),1.0F,false)
    }

    fun pauseTimer(){
        _wannaPause.value = true
    }

    private fun stopTimer(){
        countDownTimer?.cancel()
        handleTimerValues(false,model1.TimeCountDown.formatTime(),1.0F,false)
    }


    private fun startTimer(){
        _isPlaying.value = true

        countDownTimer = object : CountDownTimer(model1.TimeCountDown,1000){
            override fun onTick(millisRemaining: Long) {
                val progressValue = millisRemaining.toFloat()/model1.TimeCountDown
                if (wannaPause.value == true){
                    model1.TimeCountDown = millisRemaining + 1000L
                    handleTimerValues(true,milli.formatTime(),progressValue1,true)
                    stopTimer()

                    return
                }
                else{
                    progressValue1 = progressValue
                    milli = millisRemaining
                    handleTimerValues(true,millisRemaining.formatTime(),progressValue,false)
                }
            }
            override fun onFinish(){
                stopTimer()
            }
        }.start()
    }

    private fun handleTimerValues(isPlaying:Boolean,text:String,progress: Float,wannaPause:Boolean){
        _isPlaying.value = isPlaying
        _time.value = text
        _progress.value = progress
        _wannaPause.value = wannaPause
    }
}