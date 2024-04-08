package com.dilip.activitycycledemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
        Log.i("MYTAG", "MainActivity: OnCreate")
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
                Log.i("MYTAG", message)
                greetingTextView.text = message
                Log.i("MYTAG", "After the displaying the text message on the TextView")
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

    override fun onStart() {
        super.onStart()
        Log.i("MYTAG", "MainActivity: OnStart")
        Toast.makeText(getApplicationContext(),"OnStart",Toast.LENGTH_SHORT).show(); 
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG", "MainActivity: OnResume")
        Toast.makeText(getApplicationContext(),"onResume",Toast.LENGTH_SHORT).show(); 
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG", "MainActivity: OnPause")
        Toast.makeText(getApplicationContext(),"onPause",Toast.LENGTH_SHORT).show(); 
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAG", "MainActivity: OnStop")
        Toast.makeText(getApplicationContext(),"onStop",Toast.LENGTH_SHORT).show(); 
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAG", "MainActivity: OnDestroy")
        Toast.makeText(getApplicationContext(),"onDestroy",Toast.LENGTH_SHORT).show(); 
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MYTAG", "MainActivity: OnRestart")
        Toast.makeText(getApplicationContext(),"onRestart",Toast.LENGTH_SHORT).show(); 
    }

}