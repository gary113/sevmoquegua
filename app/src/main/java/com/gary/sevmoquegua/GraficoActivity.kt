package com.gary.sevmoquegua

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gary.sevmoquegua.clases.PuntoMedida
import com.jjoe64.graphview.DefaultLabelFormatter
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.android.synthetic.main.activity_grafico.*
import java.lang.Float
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow


class GraficoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grafico)


        /*
        val listaPuntos = intent.getParcelableArrayListExtra<PuntoMedida>("listaPuntos")

        val puntos = ArrayList<Entry>()

        for (punto in listaPuntos!!){
            puntos.add(Entry(punto.ab2.toFloat(), punto.rho.toFloat()))
        }

        val dataset = LineDataSet(puntos,"Medidas")

        val lineData = LineData(dataset)

        chGrafico.setScaleEnabled(false)
        chGrafico.data=lineData
        chGrafico.description.isEnabled=false
        chGrafico.axisRight.isEnabled = false;
        chGrafico.axisLeft.isGranularityEnabled=true
        chGrafico.axisLeft.granularity=100f

        chGrafico.invalidate()

         */

        val listaPuntos = intent.getParcelableArrayListExtra<PuntoMedida>("listaPuntos")

        //Creates an ArrayList
        //Creates an ArrayList
        val testList: ArrayList<DataPoint> = ArrayList()

        //Populates the arrayList whit some values

        //Populates the arrayList whit some values
        /*
        val value1 = log10(1.0)
        val value2 = log10(10.0)
        val value3 = log10(100.0)
        val value4 = log10(1000.0)
        val value5 = log10(10000.0)
        testList.add(DataPoint(0.0, value1))
        testList.add(DataPoint(1.0, value2))
        testList.add(DataPoint(2.0, value3))
        testList.add(DataPoint(3.0, value4))
        testList.add(DataPoint(4.0, value5))

         */

        for (punto in listaPuntos!!){
            testList.add(DataPoint(punto.ab2,log10(punto.rho)))
        }

        //Converts ArrayList<DataPoints> to DataPoints[] array

        //Converts ArrayList<DataPoints> to DataPoints[] array
        var test: Array<DataPoint?>? = arrayOfNulls(testList.size)
        test = testList.toArray(test!!)

        //Adds the dataPoint array to the graph

        //Adds the dataPoint array to the graph
        val seriesLine = LineGraphSeries(test)
        grafico.addSeries(seriesLine)

        //Defines graph structure
        grafico.viewport.isYAxisBoundsManual = true
        grafico.viewport.setMaxY(floor(log10(10000.0)))
        grafico.viewport.setMinY(0.0)

        grafico.viewport.isXAxisBoundsManual = true
        grafico.viewport.setMinX(0.0)
        grafico.viewport.setMaxX(50.0)

        grafico.legendRenderer.isVisible = true


        grafico.gridLabelRenderer.labelFormatter = object : DefaultLabelFormatter() {
            override fun formatLabel(value: Double, isValueX: Boolean): String {
                return if (isValueX) {
                    super.formatLabel(value, isValueX)
                } else {
                    val yValue = super.formatLabel(value, isValueX).replace(",".toRegex(), ".")
                    val yLogValue = floor(10.0.pow(Float.valueOf(yValue).toDouble()))
                    if (value <= 0) "0" else yLogValue.toString()
                }
            }
        }

    }
}