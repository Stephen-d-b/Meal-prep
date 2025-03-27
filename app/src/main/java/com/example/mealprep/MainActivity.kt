package com.example.mealprep

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtInput=findViewById<EditText>(R.id.txtInput)
        val btnGenMeal=findViewById<Button>(R.id.btnGenMeal)
        val lblOutput=findViewById<TextView>(R.id.lblOutput)
        val btnReset=findViewById<Button>(R.id.btnReset)

        btnReset.setOnClickListener{
            txtInput.text.clear()
            lblOutput.text=""
        }

        
    }
}