package com.abernikov.myfirstapplication

import android.content.Context

object Settings {
    private const val THEME = "chosen_theme"
    private const val KEY_THEME = "key_theme"

    fun saveTheme(context: Context, theme: Int) {
        val sharedPreferences = context.getSharedPreferences(THEME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(KEY_THEME, theme)
        editor.apply()
    }
    fun loadTheme(context: Context): Int {
        val sharedPreferences = context.getSharedPreferences(THEME, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(KEY_THEME, 1)
    }

}