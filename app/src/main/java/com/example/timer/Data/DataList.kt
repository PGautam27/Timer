package com.example.timer.Data

import java.util.concurrent.TimeUnit

data class DataList(
    val id : Int,
    val timeContent : Long = 60000L,
    val value: String
){
    private val TIME_FORMAT = "%02d:%02d:%02d"

    fun Long.formatTime(): String = String.format(
        TIME_FORMAT,
        TimeUnit.MILLISECONDS.toHours(this),
        TimeUnit.MILLISECONDS.toMinutes(this),
        TimeUnit.MILLISECONDS.toSeconds(this) % 60
    )
}


data class SomeList(
   private val dataLists: Array<DataList> = emptyArray()
){
   val time =  listOf(
    DataList(1,600000L,"10 min"),
    DataList(2,300000L, "5 min"),
    DataList(3,900000L, "15 min"),
    DataList(4,1200000L, "20 min"),
    DataList(5,1500000L, "25 min"),
    DataList(6,1800000L, "30 min"),
    DataList(7,30000L,"30 sec"),
    ) + dataLists

    fun getTimeContentById(id : Int) :  Long{
       val data =  time.find { it.id == id }
        selectedTime = data
       return data?.let { it.timeContent } ?: 0L
    }

    var selectedTime : DataList? = null;
}
