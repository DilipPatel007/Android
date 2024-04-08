package com.dilip.activitycycledemo

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.i("MYTAG", "SecondActivity: OnCreate")
        val userName = intent.getStringExtra("USER")
        val textView = findViewById<TextView>(R.id.tvOffers)
        val message = "$userName, you will get one month free subscription for free."
        textView.text = message
    }

    override fun onStart() {
        super.onStart()
        Log.i("MYTAG", "SecondActivity: OnStart")
        Toast.makeText(SecondActivity.this,"onStart",Toast.LENGTH_SHORT).show(); 
    }

    override fun onResume() {
        super.onResume()
        Log.i("MYTAG", "SecondActivity: OnResume")
        Toast.makeText(SecondActivity.this,"OnResume",Toast.LENGTH_SHORT).show(); 
    }

    override fun onPause() {
        super.onPause()
        Log.i("MYTAG", "SecondActivity: OnPause")
        Toast.makeText(SecondActivity.this,"OnPause",Toast.LENGTH_SHORT).show(); 
    }

    override fun onStop() {
        super.onStop()
        Log.i("MYTAG", "SecondActivity: OnStop")
        Toast.makeText(SecondActivity.this,"OnStop",Toast.LENGTH_SHORT).show(); 
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MYTAG", "SecondActivity: OnDestroy")
        Toast.makeText(SecondActivity.this,"OnDestroy",Toast.LENGTH_SHORT).show(); 
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MYTAG", "SecondActivity: OnRestart")
        Toast.makeText(SecondActivity.this,"onRestart",Toast.LENGTH_SHORT).show(); 
    }

}