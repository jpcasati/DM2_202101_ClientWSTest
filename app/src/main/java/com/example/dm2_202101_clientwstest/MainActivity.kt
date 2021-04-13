package com.example.dm2_202101_clientwstest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCarro.setOnClickListener {
            startActivity(Intent(this, CarroActivity::class.java))
        }

        btnOi.setOnClickListener {

            val nome = edtNome.text.toString()

            Toast.makeText(this, ClientWS().receberOi(nome), Toast.LENGTH_LONG).show()

        }

        btnTchau.setOnClickListener {
            Toast.makeText(this, ClientWS().receberTchau(edtNome.text.toString()), Toast.LENGTH_LONG).show()
        }

    }
}
