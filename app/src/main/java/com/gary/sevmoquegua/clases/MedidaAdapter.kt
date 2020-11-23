package com.gary.sevmoquegua.clases

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gary.sevmoquegua.R
import kotlinx.android.synthetic.main.item_datos.view.*

class MedidaAdapter(private val listaMedidas:ArrayList<Medida> = ArrayList()):RecyclerView.Adapter<MedidaAdapter.MedidaViewHolder>(){

    class MedidaViewHolder(view:View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedidaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_datos,parent,false)
        return MedidaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedidaViewHolder, position: Int) {
        holder.itemView.tvSp.text=listaMedidas[position].sp.toString()
        holder.itemView.tvPi.text=listaMedidas[position].pi.toString()
        holder.itemView.tvI.text=listaMedidas[position].i.toString()
        holder.itemView.tvR.text=listaMedidas[position].r.toString()
    }

    override fun getItemCount(): Int {
        return listaMedidas.size
    }

}