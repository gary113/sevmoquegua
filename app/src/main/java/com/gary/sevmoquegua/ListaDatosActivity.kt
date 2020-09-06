package com.gary.sevmoquegua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.gary.sevmoquegua.clases.Medida
import com.gary.sevmoquegua.clases.MedidaAdapter
import kotlinx.android.synthetic.main.activity_lista_datos.*

class ListaDatosActivity : AppCompatActivity() {

    private val valoresAB2= doubleArrayOf(1.0,1.5,2.0,3.0,3.0,4.0,5.0,6.0,6.0,7.0,8.0,9.0,9.0,12.0,15.0,20.0,20.0,25.0,30.0,30.0,35.0,40.0,45.0,50.0)
    private val valoresMN= doubleArrayOf(0.5,0.5,1.0,1.0,2.0,2.0,2.0,2.0,3.0,3.0,3.0,3.0,5.0,5.0,5.0,5.0,7.0,7.0,7.0,20.0,20.0,20.0,20.0,20.0)

    companion object{
        private val listaMedidas = ArrayList<Medida>()
        private val adaptador = MedidaAdapter(listaMedidas)

        fun agregarMedida(medida:Medida){
            listaMedidas.add(medida)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_datos)

        //listaMedidas.add(Medida(1.0,2.0,3.0,4.0))
        //listaMedidas.add(Medida(4.0,3.0,2.0,1.0))

        rvLista.adapter= adaptador
        rvLista.layoutManager=LinearLayoutManager(this)

        bAgregar.setOnClickListener {

            if(listaMedidas.size<24){
                val intentLlenarDatos = Intent(this, LlenarDatosActivity::class.java)
                intentLlenarDatos.putParcelableArrayListExtra("listaMedidas", listaMedidas)
                startActivity(intentLlenarDatos)
            }else{
                Toast.makeText(this,"Se alcanzó la cantidad máxima de medidas",Toast.LENGTH_SHORT).show()
            }

        }

        bBorrar1.setOnClickListener{
            if (listaMedidas.size>0){
                listaMedidas.removeLast()
                adaptador.notifyDataSetChanged()
            }else{
                Toast.makeText(this,"No hay medidas",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        adaptador.notifyDataSetChanged()
    }

    private fun hacerCalculos(){
        /*
        for (i in 0..23){
            val diccionario = mutableMapOf<String,Double>()

            diccionario["ab/2"] = valoresAB2[i]
            diccionario["mn"] = valoresMN[i]
            diccionario["k"] = (Math.PI/valoresMN[i])*(valoresAB2[i].pow(2)-valoresMN[i].pow(2)/4)
            //diccionario["nServ"] = 1.0
            //diccionario["sp"] =
            //diccionario["pi"] =
            //diccionario["av"] =
            //diccionario["i"] =
            //diccionario["r"] =
            //diccionario["rho"] =
            //diccionario["prof"] = valoresAB2[i]*2/3

        }
         */
    }
}