package com.abernikov.myfirstapplication

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(
    itemLayoutView: View
) : RecyclerView.ViewHolder(itemLayoutView) {
    private val text: TextView = itemLayoutView.findViewById(R.id.tvFullName)
    fun bind(item: String) {
        text.text = item
        text.setOnClickListener {
            Toast.makeText(text.context, item, Toast.LENGTH_LONG).show()
        }
    }
}