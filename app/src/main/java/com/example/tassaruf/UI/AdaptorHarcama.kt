package com.example.tassaruf.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tassaruf.Database.Harcama
import android.view.View
import android.widget.TextView
import com.example.tassaruf.R



class AdaptorHarcama(var gitPara:List<Harcama>):RecyclerView.Adapter<AdaptorHarcama.HarcamaHolder> () {

inner class HarcamaHolder(itemView:View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HarcamaHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.harcama,parent,false)
        return HarcamaHolder( view)
    }

    override fun onBindViewHolder(holder: HarcamaHolder, position: Int) {
        val harcama=gitPara[position]
        holder.itemView.findViewById<TextView>(R.id.harcamaTuru).text=harcama.harcamaTuru
        holder.itemView.findViewById<TextView>(R.id.harcanaMiktari).text=harcama.harcamaMiktari.toString()
        holder.itemView.findViewById<TextView>(R.id.harcamaZamani).text=harcama.harcamaTarihi
    }

    override fun getItemCount(): Int {
        return gitPara.count()
    }
}