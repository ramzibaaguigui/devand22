package com.devfest.testHistory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devfest.R
import com.devfest.model.dataClasses.MyTestItem


class TestHistoryAdapter(private val data: List<MyTestItem>) : RecyclerView.Adapter<TestHistoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.tv_item_mytest)
        val dateTextView: TextView = itemView.findViewById(R.id.tv_date_mytest)
        val progressTextView: TextView = itemView.findViewById(R.id.tv_progress_mytest)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_my_test, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.titleTextView.text = item.testName
        holder.dateTextView.text = item.date
        holder.progressTextView.text = item.state
    }

    override fun getItemCount() = data.size
}