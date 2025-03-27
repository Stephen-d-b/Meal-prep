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
        val txtInput = findViewById<EditText>(R.id.txtInput)
        val btnGenMeal = findViewById<Button>(R.id.btnGenMeal)
        val lblOutput = findViewById<TextView>(R.id.lblOutput)
        val btnReset = findViewById<Button>(R.id.btnReset)

        btnReset.setOnClickListener {
            txtInput.text.clear()
            lblOutput.text = ""
        }
        val timeOfDay =
            listOf("Morning", "Mid-Morning", "Afternoon", "Mid-Afternoon", "Dinner") //https://kotlinlang.org//

        if (txtInput in timeOfDay) {
            val mealOptions = mapOf(
                "Morning" to listOf("Eggs", "Pancakes", "Oatmeal", "Toast & Jam"),
                "Mid-Morning" to listOf("Yogurt", "Fruit Salad", "Granola Bar"),
                "Afternoon" to listOf("Sandwich", "Salad", "Pasta", "Rice & Chicken"),
                "Mid-Afternoon" to listOf("Nuts", "Smoothie", "Biscuits"),
                "Dinner" to listOf("Steak", "Soup", "Pizza", "Grilled Fish")
            )//https://kotlinlang.org//
        }
        btnGenMeal.setOnClickListener {
            
        }
    }
}
