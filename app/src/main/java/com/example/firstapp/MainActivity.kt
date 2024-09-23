package com.example.firstapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var textInput: EditText
    private lateinit var textConverted: TextView
    private lateinit var numberOfChars: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        textInput = findViewById(R.id.textInput)
        textConverted = findViewById(R.id.textConverted)
        numberOfChars = findViewById(R.id.numberOfChars)
        button = findViewById(R.id.buttonConvert)

    }

    fun toReverse(view: View) {
        textConverted.text = textInput.text.reversed()
    }

    fun charsCounter(view: View) {
        numberOfChars.text = textInput.text.filter { it != '@' }.count().toString()
    }

    fun onButtonClick(view: View) {
        toReverse(button)
        charsCounter(button)
    }

}