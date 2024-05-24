package com.abernikov.myfirstapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.abernikov.myfirstapplication.databinding.ActivitySettingBinding


class SettingActivity : AppCompatActivity() {
    //private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController
    }


}