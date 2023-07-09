package com.isulin.jekpi.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.isulin.jekpi.R
import com.isulin.jekpi.data.OnBoardingItem

class OnBoardingAdapter(private val context: Context, private val data: List<OnBoardingItem>): RecyclerView.Adapter<OnBoardingAdapter.MyViewHolder>() {

    class MyViewHolder(val itemView: View): RecyclerView.ViewHolder(itemView) {
//        lateinit var imgView: ImageView
//        lateinit var container: ConstraintLayout
//        init {
//            imgView = itemView.findViewById(R.id.ivOnBoarding) as ImageView
//            container = itemView.findViewById(R.id.containerOnBoarding) as ConstraintLayout
//        }
        var imgView: ImageView? = itemView.findViewById(R.id.ivOnBoarding)
        var tvTitle: TextView? = itemView.findViewById(R.id.tvTitleOnBoarding)
        var tvDesc: TextView? = itemView.findViewById(R.id.tvDescOnBoarding)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_on_boarding,parent,false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        holder.imgView!!.setImageResource(item.imageResId)
        holder.tvTitle!!.text = item.title
        holder.tvDesc!!.text = item.description
    }
}

//class OnBoardingAdapter(private val context: Context, private val data: List<OnBoardingItem>) : RecyclerView.Adapter<OnBoardingAdapter.MyViewHolder>() {
//
//    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val imgView: ImageView = itemView.findViewById(R.id.ivOnBoarding)
//        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
//        val tvDesc: TextView = itemView.findViewById(R.id.tvDesc)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_on_boarding, parent, false)
//        return MyViewHolder(itemView)
//    }
//
//    override fun getItemCount(): Int {
//        return data.size
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val item = data[position]
//        holder.imgView.setImageResource(item.imageResId)
//        holder.tvTitle.text = item.title
//        holder.tvDesc.text = item.description
//    }
//}