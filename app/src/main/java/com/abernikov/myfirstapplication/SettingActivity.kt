package com.abernikov.myfirstapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.abernikov.myfirstapplication.databinding.ActivitySettingBinding


class SettingActivity : Activity() {
    private lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        Toast.makeText(this,"${Settings.loadTheme(this@SettingActivity)}",Toast.LENGTH_LONG).show()
        when (Settings.loadTheme(this@SettingActivity)) {
            2 -> {
                setTheme(R.style.AppThemeDark)
                binding.radioButtonLightStyle.isChecked = true
                binding.radioButtonNightStyle.isChecked = false
            }

            else -> {
                setTheme(R.style.AppThemeLight)
                binding.radioButtonNightStyle.isChecked = true
                binding.radioButtonLightStyle.isChecked = false
            }
        }
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.radioButtons.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radioButtonNightStyle -> Settings.saveTheme(this@SettingActivity, 2)
                R.id.radioButtonLightStyle -> Settings.saveTheme(this@SettingActivity, 1)
                else -> Settings.saveTheme(this@SettingActivity, 1)
            }
        }
        binding.ivBack.setOnClickListener {
            startActivity(Intent(this@SettingActivity, MainActivity::class.java))
            finish()
        }
        binding.button.setOnClickListener {
            val address = Uri.parse("https://google.com")
            val linkInet = Intent(Intent.ACTION_VIEW, address)
            startActivity(linkInet)
        }
    }
}