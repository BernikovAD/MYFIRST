package com.abernikov.myfirstapplication

import android.app.Application

class MyApplication : Application() {
    companion object {
        var currentTheme: Int = R.style.AppThemeLight
    }
}