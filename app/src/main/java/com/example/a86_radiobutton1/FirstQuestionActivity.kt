package com.example.a86_radiobutton1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstQuestionActivity : AppCompatActivity() {

    private lateinit var radioGroupRG: RadioGroup
    private lateinit var oneRB: RadioButton
    private lateinit var twoRB: RadioButton
    private lateinit var threeRB: RadioButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        radioGroupRG = findViewById(R.id.radioGroupRG)
        oneRB = findViewById(R.id.oneRB)
        twoRB = findViewById(R.id.twoRB)
        threeRB = findViewById(R.id.threeRB)

        radioGroupRG.setOnCheckedChangeListener { group, checkedId ->
            val radio: RadioButton = findViewById(checkedId)
            var result = 0
            if (radio.id == threeRB.id) {
                result += 100
            }
            val intent = Intent(this, SecondQuestionActivity::class.java)
            intent.putExtra("key", result.toString())
            startActivity(intent)
        }
    }
}