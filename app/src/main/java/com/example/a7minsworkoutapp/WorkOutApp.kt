package com.example.a7minsworkoutapp

import android.app.Application

class WorkOutApp : Application(){
    val db by lazy{
        HistoryDatabase.getInstance(this)
    }
}