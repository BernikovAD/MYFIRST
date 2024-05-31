package com.abernikov.myfirstapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.abernikov.myfirstapplication.MyViewHolder
import com.abernikov.myfirstapplication.R

class MyAdapter(
    private val dataSet: MutableList<String>,
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,
                parent,
                false
            ), onClickListener
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size
    fun deleteItem(position: Int) {
        dataSet.removeAt(position)
        notifyDataSetChanged()
    }
}