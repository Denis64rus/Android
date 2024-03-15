package com.example.pifagor

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pifagor.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    // binding - раздутие/раздувание разметки
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // получение результата при нажатии на кнопку
    fun onClickResult(view: View) {
        if (!isFieldEmpty()) {
            val  result = getString(R.string.result_info) + getResult()
            binding.tvResult.text = result
        }
    }

    // проверка полей ввода на пустоту через id элементов (полей ввода)
    private fun isFieldEmpty(): Boolean{
        binding.apply {
            if (edA.text.isNullOrEmpty()) edA.error = "Поле должно быть заполнено"
            if (edB.text.isNullOrEmpty()) edB.error = "Поле должно быть заполнено"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }

    // функция для вычислений (Теорема Пифагора)
    private fun getResult(): String{
        val a: Double
        val b: Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        return sqrt(a.pow(2) + b.pow(2)).toString()
    }

}