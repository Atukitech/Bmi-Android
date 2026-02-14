package com.example.bmi_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmi_calculator.databinding.ActivityMainBinding
import com.example.bmi_calculator.databinding.ActivityWelcomePageBinding

class WelcomePage : AppCompatActivity() {
    private  lateinit var binding: ActivityWelcomePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityWelcomePageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.nextBtn.setOnClickListener {
            Toast.makeText(this, "Next button clicked", Toast.LENGTH_SHORT).show()

            startActivity(Intent(this@WelcomePage, MainActivity::class.java))
        }

    }
}