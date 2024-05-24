package com.abernikov.myfirstapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.abernikov.myfirstapplication.databinding.ActivitySettingBinding


class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(
            this@SettingActivity,
            "${Settings.loadTheme(this@SettingActivity)}",
            Toast.LENGTH_LONG
        ).show()
        val binding = ActivitySettingBinding.inflate(layoutInflater)
        when (Settings.loadTheme(this)) {
            2 -> {
                setTheme(R.style.AppThemeDark)
            }

            1 -> {
                setTheme(R.style.MyFirstApplication)
            }
        }
        setContentView(binding.root)
        (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController
    }


}