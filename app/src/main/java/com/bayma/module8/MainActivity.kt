package com.bayma.module8

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var numberOfClicks = 0
        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)
        val screen = findViewById<LinearLayoutCompat>(R.id.screen)

        editText.addTextChangedListener {
            showTextOnTextView(textView, numberOfClicks, it.toString())
        }

        button.setOnClickListener {
            numberOfClicks++
            screen.background = when {
                numberOfClicks % 2 == 0 -> getDrawable(R.drawable.new_image_foreground)
                else -> getDrawable(R.drawable.ic_launcher_background)
            }

            showTextOnTextView(textView, numberOfClicks, editText.text.toString())
        }

    }
}

fun showTextOnTextView(textView: TextView, numOfClicks: Int, inputText: String) {
    textView.text = "$inputText clicou $numOfClicks vezes"
}