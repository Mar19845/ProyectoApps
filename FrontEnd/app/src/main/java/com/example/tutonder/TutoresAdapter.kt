package com.example.tutonder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TutoresAdapter internal constructor(context: Context): RecyclerView.Adapter<TutoresAdapter.ViewHolderData>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderData {
        val itemView=inflater.inflate(R.layout.text_item_view,parent,false)
        return ViewHolderData((itemView))
    }

    override fun getItemCount()=TutoresList.size

    override fun onBindViewHolder(holder: ViewHolderData, position: Int) {
        val tutores=TutoresList[position]

        holder.tutorItenView.text=tutores.get(0)
        holder.tutor.text=tutores.get(1)
    }

    internal fun setQuestions(tutores: ArrayList<ArrayList<String>>){
        this.TutoresList=tutores

        notifyDataSetChanged()
    }

    private var inflater: LayoutInflater = LayoutInflater.from(context)
    private var TutoresList= ArrayList<ArrayList<String>>()

    //ViewHolder for the data
    inner class ViewHolderData(itemView: View): RecyclerView.ViewHolder(itemView){
        val tutorItenView: TextView =itemView.findViewById(R.id.)
        val tutor: TextView =itemView.findViewById(R.id.)
    }
}