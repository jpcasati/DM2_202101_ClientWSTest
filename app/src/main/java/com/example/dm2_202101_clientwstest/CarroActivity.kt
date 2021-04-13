package com.example.dm2_202101_clientwstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_carro.*

class CarroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carro)

        btnEnviarCarro.setOnClickListener {
            val c = Carro(edtPlaca.text.toString(), edtModelo.text.toString(), edtAno.text.toString().toInt())

            val resp = ClientWS().enviarCarro(c)

            var texto: String = "Análise não executada"

            if(resp != null) {
                if(resp.equals("nao_paga"))
                    texto = "Este carro não paga IPVA"
                else if(resp.equals("paga"))
                    texto = "Este carro paga IPVA"
            }

            Toast.makeText(this, texto, Toast.LENGTH_LONG).show()

        }

    }
}
