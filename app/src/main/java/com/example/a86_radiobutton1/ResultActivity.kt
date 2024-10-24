package com.example.a86_radiobutton1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    private lateinit var resultTV:TextView
    private lateinit var characteristicTV:TextView

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        resultTV = findViewById(R.id.resultTV)
        characteristicTV = findViewById(R.id.characteristicTV)

        val result = intent.getStringExtra("keyFive")?.toInt()
        resultTV.text = "Ваш результат: $result баллов"

        val characteristic = Characteristic()
        characteristicTV.text = when(result){
            in 0..100 -> characteristic.bad
            200 -> characteristic.unsatisfactory
            300 -> characteristic.satisfactory
            400 -> characteristic.good
            500 -> characteristic.excellent
            else ->""
        }
    }
}