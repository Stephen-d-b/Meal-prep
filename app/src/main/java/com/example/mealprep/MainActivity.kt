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

        btnGenMeal.setOnClickListener {
            val userInput = txtInput.text.toString().trim()  // Get the input as a string

            if (userInput in timeOfDay) {  // getting the user input from the variable called above
                /* giving pre determinde meals for the the time of the day using the map of function to call random meals and
                knowlage from the list of functions used in the weather app i made for ice task
                trying to give them pre determinde if this does not work use basic if functions by just with "vaste uitkomste"  */
                val mealOptions = mapOf(
                    "Morning" to listOf("Eggs", "Pancakes", "Oatmeal", "Toast & Jam"),
                    "Mid-Morning" to listOf("Yogurt", "Fruit Salad", "Granola Bar"),
                    "Afternoon" to listOf("Sandwich", "Salad", "Pasta", "Rice & Chicken"),
                    "Mid-Afternoon" to listOf("Nuts", "Smoothie", "Biscuits"),
                    "Dinner" to listOf("Steak", "Soup", "Pizza", "Grilled Fish")
                )//https://kotlinlang.org//

                val Meels = mealOptions[userInput]

                if (Meels != null) {
                    lblOutput.text = "$userInput: $Meels"
                } else {
                    lblOutput.text = "You have typed an invalid option"
                }
            }
        }
    }
}

