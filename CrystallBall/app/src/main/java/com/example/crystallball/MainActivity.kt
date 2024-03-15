package com.example.crystallball

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crystallball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        // создаем обработчик события клика на кнопку
        binding.tvReto.setOnClickListener {
            binding.tvReto.text = getReto()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    // запрашиваем информацию из массива через функцию randomNumber()
    private fun getReto(): String{
        return resources.getStringArray(R.array.retos)[randomNumber()]
    }

    // генерация случайного числа из диапазона от 0 до размера массива
    private fun randomNumber(): Int{
        val size = resources.getStringArray(R.array.retos).size - 1
        return (0..size).random()
    }
}