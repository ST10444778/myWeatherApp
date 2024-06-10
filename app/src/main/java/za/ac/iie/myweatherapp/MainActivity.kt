package za.ac.iie.myweatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
// we are going into the class where we code for the array
    private val dates = ArrayList<String>()
    private val minimums = ArrayList<Int>()
    private val maximums = ArrayList<Int>()
    private val weatherConditions = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // we are now doing to delcare everything


        val editTextMinimum = findViewById<EditText>(R.id.editTextMinumum)
        val editTextMaximum = findViewById<EditText>(R.id.editTextMaximum)
        val editTextWeatherCondition = findViewById<EditText>(R.id.editTextWeatherConditions)
        val editTextDates = findViewById<EditText>(R.id.editTextDate)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnViewDetails = findViewById<Button>(R.id.btnViewDetails)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        // we set the buttons on set click listener so that the button works when the user clicks it
        // we are making sure that we turn string into integers and visa versa

        btnAdd.setOnClickListener {
            val date = editTextDates.text.toString()
            val minimum = editTextMinimum.text.toString().toInt()
            val maximum = editTextMaximum.text.toString().toInt()
            val weatherCondition = editTextWeatherCondition.text.toString()

            if (minimum != null && maximum != null && weatherConditions.isNotEmpty() && dates.isNotEmpty()) {

                dates.add(date)
                minimums.add(minimum)
                maximums.add(maximum)
                weatherConditions.add(weatherCondition)

                Toast.makeText(
                    this, "Data was added",
                    Toast.LENGTH_SHORT
                ).show()

                clearFields(
                    editTextDates,
                    editTextMinimum,
                    editTextMaximum,
                    editTextWeatherCondition,

                )


            }


        }
        btnClear.setOnClickListener {
            finish()
        }

        btnViewDetails.setOnClickListener {
            val Intent = intent( this, detailedViewScreen::class.java)
               startActivity(intent)

            intent.putStringArrayListExtra(" the dates", dates)
            intent.putStringArrayListExtra( "weather conditions", weatherConditions)
            intent.putIntegerArrayListExtra("Minimum", minimums)
            intent. putIntegerArrayListExtra("maximum", maximums )
                startActivity(intent)




        }
        btnCalculate.setOnClickListener {
            // Array to store maximum temperatures for each day of the week
            val maximumAndMininmumTemperatures = arrayOf(12, 15, 10, 10, 25,29,18,16)

            // Calculate the sum of temperatures
            val sum: Int = maximumAndMininmumTemperatures.sum()


            // Calculate the average temperature
            val averageTemperature = sum.toDouble() / maximumAndMininmumTemperatures.size

            val intent = Intent(this, detailedViewScreen::class.java).also {
                it.putExtra("averageTemperature", averageTemperature)
                startActivity(it)
            }


        }



        }










    }

    private fun intent(mainActivity: MainActivity, java: Class<detailedViewScreen>): Any {
        TODO("Not yet implemented")

    }

    private fun clearFields(editTextDates: EditText?, editTextMinimum: EditText?, editTextMaximum: EditText?, editTextWeatherCondition: EditText?) {





    }






