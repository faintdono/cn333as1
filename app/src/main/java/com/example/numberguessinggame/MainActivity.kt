package com.example.numberguessinggame

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

    var rand: Int = nextInt(1, 100)
    var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        imageButtonReset = findViewById(R.id.imageButtonReset)
        imageButtonCheck = findViewById(R.id.imageButtonCheck)

        textView.text = "Please enter your guess:"

        imageButtonCheck.setOnClickListener {

            val n: Int = editText.text.toString().toInt()

            if (n < rand) {

                textView.text = "Wrong, your number is to low!"
                count++
                editText.text.clear()
            } else if (n > rand) {

                textView.text = "Wrong, your number is to high!"
                editText.text.clear()
                count++
            } else {

                textView.text = "Congrat, your're right! \n" +
                        "Your Guess Count: $count"
                editText.text.clear()
            }
        }
        imageButtonReset.setOnClickListener {
            resetGame()
        }
    }
    fun resetGame() {
        rand = nextInt(1,100)
        textView.text = "Please enter your guess:"
        editText.text.clear()

    }
}