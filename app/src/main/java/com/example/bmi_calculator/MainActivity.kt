package com.example.bmi_calculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import com.example.bmi_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //RESULT BINDING
        val username = intent.getStringExtra("VALUE_NAME")
        binding.resultTV.text = username
        //RESULT AGE
        val userAge: Int = intent.getIntExtra("AGE",0)
        binding.resultTV2.text = userAge.toString()


        /////////////////////////////////////////////////////////

        //SIGHNOUT BUTTON
        binding.signoutBtn.setOnClickListener {
            Toast.makeText(this, "Signout button clicked", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity, WelcomePage::class.java))
        }
        binding.calculcateBtn.setOnClickListener {
            val heightTv = binding.heightET.text.toString().trim()
            val weightTv = binding.weightET.text.toString().trim()
            /// Validation For HEIGHT
            if (heightTv.isEmpty()) {
                binding.heightTIL.error = "Enter Height"
                return@setOnClickListener
            } else {
                binding.heightTIL.error = null
            }

            //Validation for Weight
            if (weightTv.isEmpty()) {
                binding.weightTIL.error = "Enter Weight"
                return@setOnClickListener
            } else {
                binding.weightTIL.error = null
            }
            val height = heightTv.toDouble()
            val weight = weightTv.toDouble()
            if (height <= 0) {
                binding.heightTIL.error = "Height Is Wrong"
                return@setOnClickListener
            }
            //BMI CALCULATION
            //Bmi Calculation
            val bmi = weight / (height * height)

            //result section
            binding.title.parent?.let {
                (it as View).visibility = View.VISIBLE
            }
            binding.bmiResult.text = String.format("%.2f", bmi)

            //Bmi Status

            when {
                bmi < 18.5 -> {
                    binding.bmiStatus.text = "Underweight"
                    binding.bmiAdvice.text = "Eat more"
                }

                bmi in 18.5..24.9 -> {
                    binding.bmiStatus.text = "Normal"
                    binding.bmiAdvice.text = "Great!Please maintain"
                }

                bmi in 25.0..39.9 -> {
                    binding.bmiStatus.text = "Overweight"
                    binding.bmiAdvice.text = "Reduce Overweight"
                }

                bmi > 40.0 -> {
                    binding.bmiStatus.text = "Obese"
                    binding.bmiAdvice.text = "Please maintain"
                }
            }

            binding.bmiStatus.visibility = View.VISIBLE
            binding.bmiAdvice.visibility = View.VISIBLE


        }

    }
}