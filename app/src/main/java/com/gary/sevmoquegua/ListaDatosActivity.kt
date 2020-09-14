package com.gary.sevmoquegua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.gary.sevmoquegua.clases.Medida
import com.gary.sevmoquegua.clases.MedidaAdapter
import com.gary.sevmoquegua.clases.PuntoMedida
import kotlinx.android.synthetic.main.activity_lista_datos.*
import kotlin.math.pow

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

        listaMedidas.add(Medida(0.00100,0.10000,0.10000,1.00000))
        listaMedidas.add(Medida(0.04100,0.10000,0.10000,1.00000))
        listaMedidas.add(Medida(0.03800,0.10000,0.10000,0.62000))
        listaMedidas.add(Medida(0.00400,0.10000,0.10000,1.00000))
        listaMedidas.add(Medida(0.08300,0.10000,0.10000,0.00000))
        listaMedidas.add(Medida(0.00700,0.11000,0.10000,1.00000))
        listaMedidas.add(Medida(-0.07100,0.02300,0.10000,1.00000))
        listaMedidas.add(Medida(-0.02000,0.02200,0.10000,0.00000))
        listaMedidas.add(Medida(0.01400,2.00000,0.20000,10.00000))
        listaMedidas.add(Medida(0.03000,4.34000,0.10000,43.00000))
        listaMedidas.add(Medida(0.01230,5.68000,0.20000,28.00000))
        listaMedidas.add(Medida(0.02100,2.60000,0.10000,26.00000))
        listaMedidas.add(Medida(0.01800,2.00000,0.10000,19.82000))
        listaMedidas.add(Medida(0.02100,1.80000,0.10000,18.00000))
        listaMedidas.add(Medida(0.04460,3.33000,0.30000,11.00000))
        listaMedidas.add(Medida(0.04890,1.12000,0.20000,5.36000))
        listaMedidas.add(Medida(0.05000,2.72000,0.30000,8.90000))
        listaMedidas.add(Medida(-0.00590,4.04000,0.40000,10.10000))
        listaMedidas.add(Medida(0.00600,6.53000,0.50000,13.05000))
        listaMedidas.add(Medida(0.01400,9.00000,0.70000,12.80000))
        listaMedidas.add(Medida(-0.02000,6.00000,0.40000,15.05000))
        listaMedidas.add(Medida(-0.00580,7.35000,0.20000,36.78000))
        listaMedidas.add(Medida(0.03400,0.72000,1.90000,0.36000))
        listaMedidas.add(Medida(1.00000,2.00000,3.00000,0.33000))

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

        bGraficar.setOnClickListener {
            val intentGraficar = Intent(this, GraficoActivity::class.java)
            val listaPuntos=hacerCalculos()
            intentGraficar.putParcelableArrayListExtra("listaPuntos",listaPuntos)
            startActivity(intentGraficar)
        }
    }

    override fun onResume() {
        super.onResume()
        adaptador.notifyDataSetChanged()
    }

    private fun hacerCalculos():ArrayList<PuntoMedida>{
        val puntos= ArrayList<PuntoMedida>()
        var k=0.0

        for (i in 0 until listaMedidas.size){
            k=(Math.PI/valoresMN[i])*(valoresAB2[i].pow(2)-valoresMN[i].pow(2)/4)
            puntos.add(PuntoMedida(valoresAB2[i],k*(listaMedidas[i].pi-listaMedidas[i].sp)/listaMedidas[i].i))
        }

        return puntos
    }
}