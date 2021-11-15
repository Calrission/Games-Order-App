package com.example.orderapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdapterRecOrder(val list: MutableList<Game>): RecyclerView.Adapter<AdapterRecOrder.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.game_name)
        val price = itemView.findViewById<TextView>(R.id.price_game)
        val author = itemView.findViewById<TextView>(R.id.author_game)
        val src = itemView.findViewById<ImageView>(R.id.src_game)
        val close = itemView.findViewById<ImageView>(R.id.close)
        val motion = itemView.findViewById<MotionLayout>(R.id.motion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name
        Glide.with(holder.itemView.context)
            .load(list[position].background_image)
            .into(holder.src)
        holder.price.text = "$" + list[position].id.toString()

        holder.close.setOnClickListener {
            holder.motion.transitionToStart()
            list.removeAt(position)
            notifyItemRemoved(position)
            sendSum()
            notifyItemRangeChanged(position, list.size);
        }
        holder.author.text = list[position].slug
        sendSum()
    }

    private fun sendSum(){
        onChangeTotalSum.onChange(list.sumOf {it.id}, list.size)
    }

    override fun getItemCount(): Int = list.size
}