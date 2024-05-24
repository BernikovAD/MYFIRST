package com.abernikov.myfirstapplication


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.abernikov.myfirstapplication.databinding.ActivityMainBinding


class MainActivity : Activity() {

    private val str = StringBuilder()
    private var a = 0.0
    private var b = 0.0
    private var action = ""
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val KEY = "str"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        Log.i("youTag", "onCreate ${savedInstanceState?.getString("str")}")
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.buttonClear.setOnClickListener {
            str.clear()
            binding.text1.text = str.toString()
        }
        binding.button1.setOnClickListener {
            binding.text1.text = str.append(resources.getString(R.string._1))
        }
        binding.button2.setOnClickListener {
            binding.text1.text = str.append(resources.getString(R.string._2))
        }
        binding.button3.setOnClickListener {
            binding.text1.text = str.append(resources.getString(R.string._3))
        }
        binding.button4.setOnClickListener {
            binding.text1.text = str.append(resources.getString(R.string._4))
        }
        binding.button5.setOnClickListener {
            binding.text1.text = str.append(resources.getString(R.string._5))
        }
        binding.button6.setOnClickListener {
            binding.text1.text = str.append(resources.getString(R.string._6))
        }
        binding.button7.setOnClickListener {
            binding.text1.text = str.append(resources.getString(R.string._7))
        }
        binding.button8.setOnClickListener {
            binding.text1.text = str.append(resources.getString(R.string._8))
        }
        binding.button9.setOnClickListener {
            binding.text1.text = str.append(resources.getString(R.string._9))
        }
        binding.buttonZero.setOnClickListener {
            binding.text1.text = str.append(resources.getString(R.string._0))
        }
        binding.buttonPlus.setOnClickListener {
            binding.text1.text = str.append(resources.getString(R.string.plus))
        }
        binding.buttonMinus.setOnClickListener {
            binding.text1.text = str.append("-")
        }
        binding.buttonDivide.setOnClickListener {
            binding.text1.text = str.append("/")
        }
        binding.buttonMultiply.setOnClickListener {
            binding.text1.text = str.append("*")
        }
        binding.buttonPoint.setOnClickListener {
            binding.text1.text = str.append(".")
        }
        binding.buttonEquals.setOnClickListener {
            calculate()
        }
        binding.buttonSetting.setOnClickListener {
            val intent = Intent(this@MainActivity, SettingActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun calculate() {
        try {
            val input = str.toString()
            val numbers = input.split(Regex("[+-/*]"))
            if (numbers.size >= 2) {

                a = numbers[0].toDouble()

                b = numbers[1].toDouble()
                action = input[numbers[0].length].toString()
                val result = when (action) {
                    resources.getString(R.string.divide) -> {
                        (a / b)
                    }

                    resources.getString(R.string.multiply) -> {
                        (a * b)
                    }

                    resources.getString(R.string.minus) -> {
                        (a - b)
                    }

                    resources.getString(R.string.plus) -> {
                        (a + b)
                    }

                    else -> {
                        throw Exception("Error action")
                    }
                }
                if (result == result.toInt().toDouble()) {
                    binding.text1.text = result.toInt().toString()
                } else {
                    binding.text1.text = result.toString()
                }
            } else {
                Log.i("youTag", "Не правильно ввели числа")
            }
        } catch (e: Exception) {
            Log.i("youTag", e.message.toString())
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("youTag", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("youTag", "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("youTag", "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.i("youTag", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("youTag", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("youTag", "onDestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY, str.toString())

        Log.i("youTag", "onSaveInstanceState $str ${outState.getString("str")}")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i("youTag", "onRestoreInstanceState ${savedInstanceState.getString("str")}")
        str.append(savedInstanceState.getString(KEY))
        binding.text1.text = savedInstanceState.getString(KEY)
    }

}