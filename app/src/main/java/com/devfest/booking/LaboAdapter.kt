package com.devfest.booking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.devfest.R


class LaboAdapter(private val laboList: List<Labo>) :
    RecyclerView.Adapter<LaboAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lab_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val labo = laboList[position]

        // Set data to views
        holder.laboNameTextView.text = labo.name
        holder.laboLocationTextView.text = labo.location
        holder.laboRatingTextView.text = labo.rating.toString()
        holder.ratingBar.rating = labo.rating
        holder.laboImageView.setImageURI(labo.imgLink.toUri())
        holder.radioButton.isChecked = labo.isSelected

        // Set click listener for radio button
        holder.radioButton.setOnClickListener {
            // Update selected item in the list
            laboList.forEach { it.isSelected = false }
            labo.isSelected = true
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = laboList.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val laboNameTextView: TextView = itemView.findViewById(R.id.tv_labo_name)
        val laboLocationTextView: TextView = itemView.findViewById(R.id.tv_labo_location)
        val laboRatingTextView: TextView = itemView.findViewById(R.id.tv_labo_rating)
        val ratingBar: RatingBar = itemView.findViewById(R.id.my_rating_bar)
        val laboImageView: ImageView = itemView.findViewById(R.id.img_lab_item)
        val radioButton: RadioButton = itemView.findViewById(R.id.rb_loboItem)
    }
}

data class Labo(
    val name: String,
    val location: String,
    val rating: Float,
    val imgLink: String,
    var isSelected: Boolean
)