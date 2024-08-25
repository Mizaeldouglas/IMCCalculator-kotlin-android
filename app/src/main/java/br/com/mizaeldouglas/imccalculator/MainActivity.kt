package br.com.mizaeldouglas.imccalculator

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
        setContentView(R.layout.activity_main)


        val weightInput = findViewById<EditText>(R.id.weightInput)
        val heightInput = findViewById<EditText>(R.id.heightInput)
        val resultText = findViewById<TextView>(R.id.resultText)
        val calcButton = findViewById<Button>(R.id.calcButton)

        calcButton.setOnClickListener{
            val weight = weightInput.text.toString().toFloatOrNull()
            val height = heightInput.text.toString().toFloatOrNull()

            if (weight != null && height != null && height > 0) {
                val bmi = weight /(height * height)
                val idealWeightMin = 18.5 * (height * height)
                val idealWeightMax = 25.0 * (height * height)

                val message = when {
                    bmi < 18.5 -> "Seu IMC é %.2f (Magreza) ideal: %.2f kg - %.2f kg".format(bmi, idealWeightMin, idealWeightMax)
                    bmi in 18.5..25.0 -> "Seu IMC é %.2f (Normal)".format(bmi)
                    bmi in 25.0..30.0 -> "Seu IMC é %.2f (Sobrepeso) ideal: %.2f - %.2f kg".format(bmi, idealWeightMin, idealWeightMax)
                    bmi in 30.0..35.0 -> "Seu IMC é %.2f (Obesidade grau I) ideal: %.2f - %.2f kg".format(bmi, idealWeightMin, idealWeightMax)
                    bmi in 35.0..40.0 -> "Seu IMC é %.2f (Obesidade grau II) ideal: %.2f - %.2f kg".format(bmi, idealWeightMin, idealWeightMax)
                    else -> "Seu IMC é %.2f (Obesidade grau III) ideal: %.2f kg - %.2f kg".format(bmi, idealWeightMin, idealWeightMax)
                }
                resultText.text = message

            }else{
                resultText.text = "Por favor, insira valores validos."
            }
        }
    }
}