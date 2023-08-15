package com.example.evaluacion1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


class HonorarioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PagoHonorario()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PagoHonorario() {
    val context = LocalContext.current
    var valorInput by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column {

        Text("Cálculo Boleta")
        TextField(
            value = valorInput,
            onValueChange = { valorInput = it },
            label = { Text("Valor a calcular") },

        )
        Button(onClick = {
            val suelVal = valorInput.toDoubleOrNull() ?: 0.0
            val restar = suelVal * 0.2
            val res = suelVal - restar
            resultado = "Pago líquido: $res"
        },modifier = Modifier
            .padding(16.dp)
            .padding(horizontal = 40.dp)
            .fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(Color.Magenta)) {
            Text("Calcular")
        }
        TextField(
            value = resultado
            , onValueChange = { valorInput = it }
            , label = { Text("Resultado") }
            , readOnly = true
        )

        RoundedButton(
            text = "volver"
            , onClick = {
                val intent = Intent(context, MainActivity::class.java)
                context.startActivity(intent)
            }
        )
    }
}