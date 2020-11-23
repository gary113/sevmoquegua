package com.gary.sevmoquegua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gary.sevmoquegua.clases.Medida
import kotlinx.android.synthetic.main.activity_llenar_datos.*
import kotlinx.android.synthetic.main.activity_llenar_datos.bAgregar

class LlenarDatosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_llenar_datos)

        bAgregar.setOnClickListener {
            if(etSp.text.toString()!="" && etPi.text.toString()!="" && etI.text.toString()!="" && etR.text.toString()!="") {

                val nuevaMedida = Medida(
                    etSp.text.toString().toDouble(),
                    etPi.text.toString().toDouble(),
                    etI.text.toString().toDouble(),
                    etR.text.toString().toDouble()
                )

                ListaDatosActivity.agregarMedida(nuevaMedida)
                super.onBackPressed()
            }else{
                Toast.makeText(this,"Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        bCancelar.setOnClickListener {
            super.onBackPressed()
        }

    }
}