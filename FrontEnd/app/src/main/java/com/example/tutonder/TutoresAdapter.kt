package com.example.tutonder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.text_item_view.view.*

class TutoresAdapter internal constructor(context: Context): RecyclerView.Adapter<TutoresAdapter.ViewHolderData>(){

    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var tutoresList= ArrayList<ArrayList<String>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderData {
        val itemView=inflater.inflate(R.layout.text_item_view,parent,false)
        return ViewHolderData((itemView))
    }

    override fun getItemCount()=tutoresList.size

    override fun onBindViewHolder(holder: ViewHolderData, position: Int) {
        val tutores=tutoresList[position]

        holder.tutorItemView.text= tutores[0]
        holder.tutorButton.bttVerPerfil.text= tutores[1]
    }

    internal fun setQuestions(tutores: ArrayList<ArrayList<String>>){
        this.tutoresList=tutores

        notifyDataSetChanged()
    }

    //ViewHolder for the data
    inner class ViewHolderData(itemView: View): RecyclerView.ViewHolder(itemView){
        val tutorItemView: TextView =itemView.findViewById(R.id.bttVerPerfil)
        val tutorButton: TextView =itemView.findViewById(R.id.txtVnombre)
    }
}