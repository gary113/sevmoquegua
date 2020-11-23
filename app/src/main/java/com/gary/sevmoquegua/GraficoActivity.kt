package com.gary.sevmoquegua

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gary.sevmoquegua.clases.PuntoMedida
import com.jjoe64.graphview.DefaultLabelFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.android.synthetic.main.activity_grafico.*
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow


class GraficoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grafico)

        val listaPuntos = intent.getParcelableArrayListExtra<PuntoMedida>("listaPuntos")
        val listaTendencia = intent.getParcelableArrayListExtra<PuntoMedida>("listaTendencia")

        for (i in 0 until listaTendencia!!.size){
            if (listaTendencia[i].rho<=0 && i>0){
                listaTendencia[i].rho=listaTendencia[i-1].rho
            }
        }

        //Creates an ArrayList
        val testList: ArrayList<DataPoint> = ArrayList()
        val testList2: ArrayList<DataPoint> = ArrayList()


        for (punto in listaPuntos!!){
            testList.add(DataPoint(punto.ab2, log10(punto.rho)))
        }

        for (tendencia in listaTendencia){
            testList2.add(DataPoint(tendencia.ab2, log10(tendencia.rho)))
        }


        //Converts ArrayList<DataPoints> to DataPoints[] array
        var test: Array<DataPoint?> = arrayOfNulls(testList.size)
        test = testList.toArray(test)

        var test2: Array<DataPoint?> = arrayOfNulls(testList2.size)
        test2 = testList2.toArray(test2)

        //Adds the dataPoint array to the graph

        //Adds the dataPoint array to the graph
        val seriesLine = LineGraphSeries(test)
        seriesLine.title="Datos"
        seriesLine.color= Color.WHITE
        seriesLine.thickness=2
        seriesLine.isDrawDataPoints=true
        seriesLine.dataPointsRadius=10f
        //seriesLine.setAnimated(true)
        grafico.addSeries(seriesLine)

        grafico.isCursorMode=true

        val seriesLine2 = LineGraphSeries(test2)
        seriesLine2.color= Color.YELLOW
        seriesLine2.title="Tendencia"
        //seriesLine2.setAnimated(true)
        seriesLine2.thickness=15
        grafico.addSeries(seriesLine2)

        //Defines graph structure
        grafico.viewport.isYAxisBoundsManual = true
        grafico.viewport.setMaxY(floor(log10(10000.0)))
        grafico.viewport.setMinY(0.0)

        grafico.viewport.isXAxisBoundsManual = true
        grafico.viewport.setMinX(0.0)
        grafico.viewport.setMaxX(50.0)

        //grafico.legendRenderer.isVisible = true

        grafico.gridLabelRenderer.horizontalAxisTitle="AB/2 mts"
        grafico.gridLabelRenderer.verticalAxisTitle="Resistividad ρ Ω.m"
        grafico.gridLabelRenderer.numHorizontalLabels=6
        grafico.gridLabelRenderer.padding=40
        grafico.gridLabelRenderer.gridColor=Color.RED


        grafico.gridLabelRenderer.labelFormatter = object : DefaultLabelFormatter() {
            override fun formatLabel(value: Double, isValueX: Boolean): String {
                return if (isValueX) {
                    super.formatLabel(value, isValueX).replace(",",".")
                } else {
                    val yValue = super.formatLabel(value, isValueX).replace(",",".")
                    val yLogValue = floor(10.0.pow(yValue.toDouble()))
                    yLogValue.toString()
                }
            }
        }

    }
}