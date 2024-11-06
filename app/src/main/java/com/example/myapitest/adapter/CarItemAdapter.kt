package com.example.myapitest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapitest.R
import com.example.myapitest.model.CarValue
import com.example.myapitest.ui.loadUrl

class CarItemAdapter(
    private val cars: List<CarValue>,
    private val itemClickListener: (CarValue) -> Unit,
) : RecyclerView.Adapter<CarItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.image)
        val nameTextView: TextView = view.findViewById(R.id.name)
        val yearTextView: TextView = view.findViewById(R.id.year)
        val licenceTextView: TextView = view.findViewById(R.id.license)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_car_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = cars.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = cars[position]
       holder.itemView.setOnClickListener {
           itemClickListener.invoke(item)
       }
        holder.nameTextView.text = item.name

        holder.yearTextView.text = item.year

        holder.licenceTextView.text = item.licence

        holder.imageView.loadUrl(item.imageUrl)
    }
}