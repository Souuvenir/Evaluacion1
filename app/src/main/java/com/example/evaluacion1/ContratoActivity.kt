package com.example.evaluacion1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class ContratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contrato)

        val btnVol = findViewById<Button>(R.id.buttonVolver)
        val valorInput: EditText;
        valorInput = findViewById(R.id.editTextNumber);

        btnVol.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val btnCal = findViewById<Button>(R.id.contratoButton)
        btnCal.setOnClickListener {
            calculate(valorInput)
        }
    }
    private fun calculate(valorInput : EditText) {
        val suelVal = valorInput.text.toString().toDoubleOrNull() ?: 0.0
        val restar = suelVal * 0.2
        val res = suelVal - restar

        val resTextView = findViewById<TextView>(R.id.editTextNumber2)
        resTextView.text = "El sueldo liquido es $res"
    }
}