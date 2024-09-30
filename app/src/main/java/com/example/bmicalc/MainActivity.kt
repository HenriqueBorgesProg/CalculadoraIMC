package com.example.bmicalc

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.weightPicker.minValue = 30
        binding.weightPicker.maxValue = 150

        binding.heightPicker.minValue = 100
        binding.heightPicker.maxValue = 250

        binding.weightPicker.setOnValueChangedListener { _, _, _ ->

            calculateBmi()
        }
        binding.heightPicker.setOnValueChangedListener { _, _, _ ->

            calculateBmi()
        }


    }

    private fun calculateBmi() {

        var height = binding.heightPicker.value
        var doubleheight = height.toDouble() / 100

        var weight = binding.weightPicker.value
        var imc = weight.toDouble() / (doubleheight * doubleheight)
        binding.resultsTv.text = String.format("Seu Imc é: %.2f", imc)
        binding.healthyTv.text = String.format("Considerado: %s", healthyMessage(imc))


    }

    private fun healthyMessage(imc: Double): String {
        if (imc < 18.5)
            return "Abaixo do Peso"
        if (imc < 25.0)
            return "Saudável"
        if (imc < 30)
            return "Sobrepeso"
        return "Obeso"
    }


}
