package com.example.bmi_calculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.bmi_calculator.databinding.ActivityWelcomePageBinding

class WelcomePage : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWelcomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nextBtn.setOnClickListener {
            val name = binding.nameET.text.toString().trim()

            val age = binding.ageET.text.toString().trim().toInt()

            if (name.isEmpty()) {
                binding.nameTIL.error = "Enter Name"
                return@setOnClickListener
            } else {
                binding.nameTIL.error = null
            }

            val intent = Intent(this@WelcomePage, MainActivity::class.java)
            intent.putExtra("VALUE_NAME", name)
            intent.putExtra("AGE", age)
            startActivity(intent)
        }
    }
}








