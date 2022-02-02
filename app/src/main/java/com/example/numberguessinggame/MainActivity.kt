package com.example.numberguessinggame

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var imageButtonReset: ImageButton
    lateinit var imageButtonCheck: ImageButton

    private var rand: Int = nextInt(1, 1000)
    private var count: Int = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        imageButtonReset = findViewById(R.id.imageButtonReset)
        imageButtonCheck = findViewById(R.id.imageButtonCheck)

        textView.text = "Try to guess the number that I'm think (1-1000)"

        imageButtonCheck.setOnClickListener {

            val n: Int = editText.text.toString().toInt()

            if (n < rand) {

                textView.text = "Wrong, your number is too low!"
                editText.text.clear()
                count++

            } else if (n > rand) {

                textView.text = "Wrong, your number is too high!"
                editText.text.clear()
                count++

            } else {

                textView.text = "Yeah that's it !\n" +
                        "Your Guess Count: $count"
                editText.text.clear()

            }
        }


        imageButtonReset.setOnClickListener {
            resetGame()
        }
    }

    private fun resetGame() {
        rand = nextInt(1, 100)
        textView.text = "Please enter your guess:"
        editText.text.clear()

    }
}