package com.example.download_manager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter3(val userList: ArrayList<Publicacion>) : RecyclerView.Adapter<RecyclerAdapter3.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.lista_publicaciones, viewGroup, false)
        return ViewHolder(v)
    }

    private lateinit var contexto: Context

    override fun getItemCount(): Int {
        return userList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtNombre: TextView
        var txt_fecha: TextView
        var imagen:ImageView
        init {
            txtNombre = itemView.findViewById(R.id.txt_nombre3)
            txt_fecha=itemView.findViewById(R.id.txt_fecha3)
            imagen=itemView.findViewById(R.id.imageView2)
            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                val intent= Intent(contexto, MainActivity4::class.java)
                val b = Bundle();
                b.putString("id", userList[position].id);
                intent.putExtras(b);
                ContextCompat.startActivity(contexto, intent, b)
                Snackbar.make(v, "Item Selecccionado $position",
                    Snackbar.LENGTH_LONG).setAction("Actción", null).show()
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        contexto=holder.itemView.context;
        holder.txtNombre.text = userList[position].nombres
        holder.txt_fecha.text = userList[position].publicacion
        holder.imagen.setImageResource(userList[position].img)
    }
}