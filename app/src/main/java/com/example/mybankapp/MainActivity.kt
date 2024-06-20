package com.example.mybankapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var cuentaBancaria: CuentaBancaria
    private lateinit var textViewSaldo: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cuentaBancaria = CuentaBancaria("1234567890", "Angel Anzatuña", 1000.0)

        textViewSaldo = findViewById(R.id.textViewSaldo)
        val buttonDepositar = findViewById<Button>(R.id.buttonDepositar)
        val buttonRetirar = findViewById<Button>(R.id.buttonRetirar)

        actualizarSaldo()

        buttonDepositar.setOnClickListener {
            cuentaBancaria.depositar(100.0)
            actualizarSaldo()
        }

        buttonRetirar.setOnClickListener {
            cuentaBancaria.retirar(100.0)
            actualizarSaldo()
        }
    }

    private fun actualizarSaldo() {
        val saldoActual = cuentaBancaria.consultarSaldo()
        textViewSaldo.text = "Saldo: \$${String.format("%.2f", saldoActual)}"
    }
}

