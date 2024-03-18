package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val greetingTextView = findViewById<TextView>(R.id.HelloWorld)
        val inputField = findViewById<EditText>(R.id.tvText)
        val submitButton = findViewById<Button>(R.id.button)
        val offersButton = findViewById<Button>(R.id.btnOffers)

        var enteredName = ""
        submitButton.setOnClickListener{
            enteredName = inputField.text.toString()
            if (enteredName == "") {
                offersButton.visibility = INVISIBLE
                greetingTextView.text = ""
                Toast.makeText(this@MainActivity, "Please, Enter your name", Toast.LENGTH_SHORT).show()
            } else {
                val message = "Welcome $enteredName"
                greetingTextView.text = message
                inputField.text.clear()
                offersButton.visibility = VISIBLE
            }

            offersButton.setOnClickListener {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("USER", enteredName)
                startActivity(intent)
            }




        }
    }
}