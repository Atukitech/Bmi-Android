package com.example.bmi_calculator

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bmi_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

     binding.calculateBtn.setOnClickListener {
         val heightTv = binding.heightET.text.toString().trim()
         val weightTv = binding.weightET.text.toString().trim()
     /// Validation For HEIGHT
         if (heightTv.isEmpty()){
             binding.heightTIL.error= "Enter Height"
             return@setOnClickListener
         }else{
             binding.heightTIL.error=null
         }

     //Validation for Weight
         if (weightTv.isEmpty()){
             binding.weightTIL.error= "Enter Weight"
             return@setOnClickListener
         }else{
             binding.weightTIL.error=null
         }
         val height = heightTv.toDouble()
         val weight = weightTv.toDouble()
         if(height<=0){
             binding.heightTIL.error= "Height Is Wrong"
             return@setOnClickListener
         }
         //BMI CALCULATION
         //Bmi Calculation
         val bmi = weight/(height*height)

         //result section
         binding.title.parent?.let{
             (it as View).visibility= View.VISIBLE
         }
         binding.bmiResult.text = String.format("%.2f",bmi)

         //Bmi Status

         when{
             bmi<18.5 ->{
                 binding.bmiStatus.text ="Underweight"
                 binding.bmiAdvice.text="Eat more"
             }
             bmi in 18.5..24.9-> {
                 binding.bmiStatus.text ="Normal"
                 binding.bmiAdvice.text="Great!Please maintain"
             }
             bmi in 25.0..39.9-> {
                 binding.bmiStatus.text ="Overweight"
                 binding.bmiAdvice.text="Reduce Overweight"
             }
             bmi >40.0-> {
                 binding.bmiStatus.text ="Obese"
                 binding.bmiAdvice.text="Please maintain"
             }
         }

         binding.bmiStatus.visibility= View.VISIBLE
         binding.bmiAdvice.visibility= View.VISIBLE
         //


     }

    }
}