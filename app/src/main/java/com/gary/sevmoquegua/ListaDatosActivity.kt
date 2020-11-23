package com.gary.sevmoquegua

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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


        listaMedidas.add(Medida(0.001,0.1,0.1,1.0))
        listaMedidas.add(Medida(0.041,0.1,0.1,1.0))
        listaMedidas.add(Medida(0.038,0.1,0.1,6.20E-01))
        listaMedidas.add(Medida(0.004,0.1,0.1,1.0))
        listaMedidas.add(Medida(0.083,0.1,0.1,0.0))
        listaMedidas.add(Medida(0.007,0.11,0.1,1.0))
        listaMedidas.add(Medida(-0.071,0.023,0.1,1.0))
        listaMedidas.add(Medida(-0.02,0.022,0.1,0.0))
        listaMedidas.add(Medida(0.014,2.0,0.2,10.0))
        listaMedidas.add(Medida(0.03,4.34,0.1,43.0))
        listaMedidas.add(Medida(0.0123,5.68,0.2,28.0))
        listaMedidas.add(Medida(0.021,2.6,0.1,26.0))
        listaMedidas.add(Medida(0.018,2.0,0.1,19.82))
        listaMedidas.add(Medida(0.021,1.8,0.1,18.0))
        listaMedidas.add(Medida(0.0446,3.33,0.3,11.0))
        listaMedidas.add(Medida(0.0489,1.12,0.2,5.3555))
        listaMedidas.add(Medida(0.05,2.72,0.3,8.9))
        listaMedidas.add(Medida(-0.0059,4.04,0.4,1.01E+01))
        listaMedidas.add(Medida(0.006,6.53,0.5,13.048))
        listaMedidas.add(Medida(0.014,9.0,0.7,1.28E+01))
        listaMedidas.add(Medida(-0.02,6.0,0.4,15.05))
        listaMedidas.add(Medida(-0.0058,7.35,0.2,36.779))
        listaMedidas.add(Medida(0.034,0.72,1.9,0.361052632))


/*
        listaMedidas.add(Medida(-0.032,2.08,0.1,21.0))
        listaMedidas.add(Medida(0.011,0.98,0.1,10.0))
        listaMedidas.add(Medida(0.053,1.09,0.1,1.04E+01))
        listaMedidas.add(Medida(-0.013,0.85,0.1,9.0))
        listaMedidas.add(Medida(-0.014,1.34,0.1,14.0))
        listaMedidas.add(Medida(-0.0312,2.37,0.1,24.0))
        listaMedidas.add(Medida(-0.03,0.9,0.1,9.0))
        listaMedidas.add(Medida(-0.01,1.35,0.1,14.0))
        listaMedidas.add(Medida(-0.017,1.59,0.1,16.0))
        listaMedidas.add(Medida(0.021,2.22,0.2,11.0))
        listaMedidas.add(Medida(0.028,1.09,0.1,11.0))
        listaMedidas.add(Medida(0.0338,2.83,0.1,28.0))
        listaMedidas.add(Medida(-0.086,3.14,0.1,32.26))
        listaMedidas.add(Medida(-0.0172,1.56,0.2,8.0))
        listaMedidas.add(Medida(-0.0062,1.56,0.1,16.0))
        listaMedidas.add(Medida(-0.0125,0.72,0.2,3.6625))
        listaMedidas.add(Medida(-0.0201,0.63,0.2,3.2505))
        listaMedidas.add(Medida(-0.034,1.34,0.4,3.44E+00))
        listaMedidas.add(Medida(-0.0264,1.46,0.7,2.123428571))
        listaMedidas.add(Medida(-0.0199,1.68,0.7,2.43E+00))
        listaMedidas.add(Medida(-0.0054,3.8,2.7,1.409407407))
        listaMedidas.add(Medida(0.003,1.55,0.4,3.8675))

 */
/*
        listaMedidas.add(Medida(0.0363,5.54,0.1,55.0))
        listaMedidas.add(Medida(0.0414,4.45,0.1,44.0))
        listaMedidas.add(Medida(0.0229,4.0,0.1,3.98E+01))
        listaMedidas.add(Medida(-0.0204,2.62,0.1,26.0))
        listaMedidas.add(Medida(0.0026,2.23,0.2,11.0))
        listaMedidas.add(Medida(-0.198,2.1,0.1,21.0))
        listaMedidas.add(Medida(-0.0229,1.87,0.1,19.0))
        listaMedidas.add(Medida(-0.0278,1.42,0.1,2.794))
        listaMedidas.add(Medida(-0.083,1.43,0.1,15.0))
        listaMedidas.add(Medida(-0.018,1.85,0.1,19.0))
        listaMedidas.add(Medida(-0.0203,3.72,0.2,19.0))
        listaMedidas.add(Medida(-0.0045,6.59,0.4,16.0))
        listaMedidas.add(Medida(-0.0049,4.35,0.4,10.88725))
        listaMedidas.add(Medida(0.027,5.6,0.3,19.0))
        listaMedidas.add(Medida(0.022,3.4,2.9,1.0))
        listaMedidas.add(Medida(-0.0068,0.966,0.7,1.389714286))
        listaMedidas.add(Medida(-0.0128,1.163,0.7,1.679714286))
        listaMedidas.add(Medida(-0.0095,5.48,3.8,1.44E+00))
        listaMedidas.add(Medida(-0.016,3.79,2.5,1.5224))
        listaMedidas.add(Medida(-0.031,5.63,2.6,2.18E+00))
        listaMedidas.add(Medida(-0.0089,10.88,3.2,3.40278125))

 */

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
            if(listaMedidas.size>1) {
                val intentGraficar = Intent(this, GraficoActivity::class.java)
                val listaPuntos = hacerCalculos()
                val tendencia = regresionPolinomial(listaPuntos, 5)
                intentGraficar.putParcelableArrayListExtra("listaPuntos", listaPuntos)
                intentGraficar.putParcelableArrayListExtra("listaTendencia", tendencia)
                startActivity(intentGraficar)
            }else{
                Toast.makeText(this,"Agregue al menos 2 medidas",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        adaptador.notifyDataSetChanged()
    }

    private fun hacerCalculos():ArrayList<PuntoMedida>{
        val puntos= ArrayList<PuntoMedida>()
        var k: Double

        for (i in 0 until listaMedidas.size){
            k=(Math.PI/valoresMN[i])*(valoresAB2[i].pow(2)-valoresMN[i].pow(2)/4)
            puntos.add(PuntoMedida(valoresAB2[i],k*(listaMedidas[i].pi-listaMedidas[i].sp)/listaMedidas[i].i))
        }

        return puntos
    }

    private fun regresionPolinomial(listaPuntos:ArrayList<PuntoMedida>,grado:Int):ArrayList<PuntoMedida>{
        val ecuacionesLineales= Array(grado+1){Array(grado+1){0.0} }
        var sumXy: Double
        var sumX: Double
        val solVector=Array(grado+1){0.0}

        for(i in 0..grado){
            sumXy=0.0
            for (j in 0 until listaPuntos.size){
                sumXy+=listaPuntos[j].ab2.pow(i)*listaPuntos[j].rho
            }
            solVector[i]=sumXy

            for (j in 0..grado){
                sumX=0.0

                if (i==0 && j==0){
                    ecuacionesLineales[i][j]=listaPuntos.size.toDouble()
                }else{
                    for (k in 0 until listaPuntos.size){
                        sumX+=listaPuntos[k].ab2.pow(j+i)
                    }
                    ecuacionesLineales[i][j]=sumX
                }
            }
        }

        var factor: Double

        for (k in 0..grado){
            for (i in (1+k)..grado){
                factor=ecuacionesLineales[i][k]/ecuacionesLineales[k][k]
                for (j in k..grado){
                    ecuacionesLineales[i][j]=ecuacionesLineales[i][j]-(factor*ecuacionesLineales[k][j])
                }
                solVector[i]=solVector[i]-factor*solVector[k]
            }
        }

        val xVector=Array(grado+1){0.0}
        var sum: Double

        xVector[grado]=solVector[grado]/ecuacionesLineales[grado][grado]

        for(i in grado-1 downTo 0){
            sum=0.0
            for (j in i+1..grado){
                sum+=ecuacionesLineales[i][j]*xVector[j]
            }
            xVector[i]=(solVector[i]-sum)/ecuacionesLineales[i][i]
        }

        val listaPuntosTendencia=ArrayList<PuntoMedida>()

        var aver=0.0
        while (aver<=listaPuntos[listaPuntos.size-1].ab2){
            listaPuntosTendencia.add(PuntoMedida(aver,calcularY(xVector,aver,grado)))
            //Log.i("Punto",listaPuntosTendencia[listaPuntosTendencia.size-1].rho.toString())
            aver+=0.1
        }
        /*
        for (i in 0..50 step 0.5){
            listaPuntosTendencia.add(PuntoMedida(i.toDouble(),calcularY(xVector,i.toDouble())))
        }

         */

        return listaPuntosTendencia

    }

    private fun calcularY(xVector:Array<Double>, punto:Double,grado:Int):Double{
        var respuesta=0.0
        for (i in 0..grado){
            respuesta+=xVector[i]*punto.pow(i)
        }
        return respuesta
    }
}