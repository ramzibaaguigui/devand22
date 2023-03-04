package com.devfest.testHistory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.devfest.R



class TestDetailAdapter(private val dataList: List<String>) : RecyclerView.Adapter<TestDetailAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_test_detail, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList[position]
        holder.tvAnalysis.text = data
        holder.ivRectangle.setImageResource(R.drawable.ic_rectangle)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAnalysis: TextView = itemView.findViewById(R.id.tv_analysis)
        val ivRectangle: ImageView = itemView.findViewById(R.id.iv_rect)
    }
}
