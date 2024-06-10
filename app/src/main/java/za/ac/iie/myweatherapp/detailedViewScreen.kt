package za.ac.iie.myweatherapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import za.ac.iie.myweatherapp.R.id.main
import za.ac.iie.myweatherapp.R.id.txtAverage

class detailedViewScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)

        val dates = intent.getStringArrayExtra("dates")?: arrayOf()


        val minimums = intent.getIntegerArrayListExtra("minimums")?: arrayListOf()

        val maximums =  intent.getIntegerArrayListExtra("maximums")?: arrayListOf()
        val weatherConditions = intent.getIntegerArrayListExtra("weatherConditions")?: arrayListOf()

        val TextView = findViewById<TextView>(R.id.textView)
        val averageScreen = findViewById<TextView>(txtAverage)
        val backbtn = findViewById<Button>(R.id.btnReturn)


        val averageTemperature = intent.getDoubleExtra("averageTemperature", 0.0)

        // Display the average temperature in a TextView
        TextView.text = "Average temperature for the week: $averageTemperature °C"



    }
}