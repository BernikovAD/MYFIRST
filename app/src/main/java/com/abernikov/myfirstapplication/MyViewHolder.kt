package com.abernikov.myfirstapplication

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abernikov.myfirstapplication.adapter.OnClickListener

class MyViewHolder(
    itemLayoutView: View,
    private val clickListener: OnClickListener
) : RecyclerView.ViewHolder(itemLayoutView) {
    private val text: TextView = itemLayoutView.findViewById(R.id.tvFullName)
    private val delete: ImageView = itemLayoutView.findViewById(R.id.ivClose)
    fun bind(item: String) {
        text.text = item
        delete.setOnClickListener {
            clickListener.onClick(position)
        }
        text.setOnClickListener {
            text.text = "dsfdsfdsfdsf"
            // Toast.makeText(text.context, item, Toast.LENGTH_LONG).show()
        }
    }
}

class MyViewHolderSecond(
    itemLayoutView: View,
    private val clickListener: OnClickListener
) : RecyclerView.ViewHolder(itemLayoutView) {
    private val text: TextView = itemLayoutView.findViewById(R.id.tvFullName)
    private val delete: ImageView = itemLayoutView.findViewById(R.id.ivClose)
    fun bind(item: String) {
        text.text = item
        delete.setOnClickListener {
            clickListener.onClick(position)
        }
        text.setOnClickListener {
            text.text = "dsfdsfdsfdsf"
            // Toast.makeText(text.context, item, Toast.LENGTH_LONG).show()
        }
    }
}

class MyViewHolderEmpty(
    itemLayoutView: View
) : RecyclerView.ViewHolder(itemLayoutView) {
    private val text: TextView = itemLayoutView.findViewById(R.id.tvFullName)
    fun bind() {
        text.text = "Список пуст"
    }
}