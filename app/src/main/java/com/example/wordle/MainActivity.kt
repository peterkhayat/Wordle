package com.example.wordle


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var wordToGuess = FourLetterWordList.getRandomFourLetterWord()
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)
        var textView = findViewById<TextView>(R.id.textView17)
        var result : String?

       // val textView = findViewById<View>(android.R.id.textView17) as EditText
        button.setOnClickListener {
            // Handle user interaction here
            //Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()
            count++
            if (count == 1) {
                findViewById<TextView>(R.id.textView2).visibility = View.VISIBLE
                textView = findViewById<TextView>(R.id.textView17)
                textView.text = findViewById<EditText>(R.id.editTextTextPersonName).text
                result = checkGuess(textView.text.toString())
                textView.visibility = View.VISIBLE
                textView = findViewById<TextView>(R.id.textView18)
                textView.text = result
                textView.visibility = View.VISIBLE
            }
            if (count == 2) {
                findViewById<TextView>(R.id.textView3).visibility = View.VISIBLE
                findViewById<TextView>(R.id.textView4).visibility = View.VISIBLE
                textView = findViewById<TextView>(R.id.textView19)
                textView.text = findViewById<EditText>(R.id.editTextTextPersonName).text
                result = checkGuess(textView.text.toString())
                textView.visibility = View.VISIBLE
                textView = findViewById<TextView>(R.id.textView20)
                textView.text = result
                textView.visibility = View.VISIBLE
            }
            if (count == 3) {
                findViewById<TextView>(R.id.textView5).visibility = View.VISIBLE
                findViewById<TextView>(R.id.textView6).visibility = View.VISIBLE
                textView = findViewById<TextView>(R.id.textView21)
                textView.text = findViewById<EditText>(R.id.editTextTextPersonName).text
                result = checkGuess(textView.text.toString())
                textView.visibility = View.VISIBLE
                textView = findViewById<TextView>(R.id.textView22)
                textView.text = result
                textView.visibility = View.VISIBLE
                textView = findViewById<TextView>(R.id.textView)
                textView.text = wordToGuess
                textView.visibility = View.VISIBLE
                button.text = "reset"
            }
            else{
                if(button.text == "reset"){
                    count = 0
                    wordToGuess = FourLetterWordList.getRandomFourLetterWord()
                    button.text = "GUESS!"
                    reset()
                }

            }
            //textView.text = counter.toString()
        }

        //val simpleEditText = findViewById<EditText>(R.id.editTextTextPersonName)
        //val strValue = simpleEditText.text.toString()

    }
    /**
     * Parameters / Fields:
     *   wordToGuess : String - the target word the user is trying to guess
     *   guess : String - what the user entered as their guess
     *
     * Returns a String of 'O', '+', and 'X', where:
     *   'O' represents the right letter in the right place
     *   '+' represents the right letter in the wrong place
     *   'X' represents a letter not in the target word
     */
    private fun checkGuess(guess: String) : String {
        var result = ""
        for (i in 0..3) {
            println("test")
            println(wordToGuess)
            if (guess[i] == wordToGuess[i]) {
                result += "O"
            }
            else if (guess[i] in wordToGuess) {
                result += "+"
            }
            else {
                result += "X"
            }
        }
        return result
    }

    private fun reset(){
        var textView = findViewById<TextView>(R.id.textView17)
        textView.visibility = View.INVISIBLE
         textView = findViewById<TextView>(R.id.textView18)
        textView.visibility = View.INVISIBLE
         textView = findViewById<TextView>(R.id.textView19)
        textView.visibility = View.INVISIBLE
         textView = findViewById<TextView>(R.id.textView20)
        textView.visibility = View.INVISIBLE
         textView = findViewById<TextView>(R.id.textView21)
        textView.visibility = View.INVISIBLE
         textView = findViewById<TextView>(R.id.textView22)
        textView.visibility = View.INVISIBLE
         textView = findViewById<TextView>(R.id.textView2)
        textView.visibility = View.INVISIBLE
         textView = findViewById<TextView>(R.id.textView3)
        textView.visibility = View.INVISIBLE
         textView = findViewById<TextView>(R.id.textView4)
        textView.visibility = View.INVISIBLE
         textView = findViewById<TextView>(R.id.textView5)
        textView.visibility = View.INVISIBLE
         textView = findViewById<TextView>(R.id.textView6)
        textView.visibility = View.INVISIBLE
         textView = findViewById<TextView>(R.id.textView)
        textView.visibility = View.INVISIBLE

    }
}