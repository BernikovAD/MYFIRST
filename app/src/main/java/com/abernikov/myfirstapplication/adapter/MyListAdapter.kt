package com.abernikov.myfirstapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abernikov.myfirstapplication.MyViewHolder
import com.abernikov.myfirstapplication.MyViewHolderEmpty
import com.abernikov.myfirstapplication.MyViewHolderSecond
import com.abernikov.myfirstapplication.R

class MyListAdapter(private val clickListener: OnClickListener) :
    ListAdapter<String, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: String, newItem: String) =
                oldItem == newItem
        }
        private const val VIEW_HOLDER = 0
        private const val VIEW_HOLDER_ANOTHER = 1
        private const val VIEW_HOLDER_EMPTY = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (currentList.isEmpty()) {
            VIEW_HOLDER_EMPTY
        } else {
            if (position % 2 == 0) {
                VIEW_HOLDER_ANOTHER
            } else {
                VIEW_HOLDER
            }
        }
    }

    override fun getItemCount(): Int {
        return if (currentList.isEmpty()) 1 else currentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_HOLDER_EMPTY -> {
                val view = layoutInflater.inflate(R.layout.item_list_empty, parent, false)
                MyViewHolderEmpty(view)
            }

            VIEW_HOLDER_ANOTHER -> {
                val view = layoutInflater.inflate(R.layout.item_list_2, parent, false)
                MyViewHolderSecond(view, clickListener)
            }

            else -> {
                val view = layoutInflater.inflate(R.layout.item_list, parent, false)
                MyViewHolderSecond(view, clickListener)
                // MyViewHolder(view,)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (currentList.isEmpty()) {
            if (holder is MyViewHolderEmpty) {
                holder.bind()
            }
        } else {
            val item = getItem(position)
            when (holder) {
                is MyViewHolder -> holder.bind(item)
                is MyViewHolderSecond -> holder.bind(item)
            }
        }
    }
}


data class model(
    val image: String,
    val title: String,
    val description: String,
    val address: String
)