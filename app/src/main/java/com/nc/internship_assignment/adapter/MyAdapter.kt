package com.nc.internship_assignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nc.internship_assignment.R
import com.nc.internship_assignment.model.UserData

class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
   private var dataList = ArrayList<UserData>()

    fun updateDataList(list: List<UserData>) {
       this.dataList = list as ArrayList<UserData>
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.row_design, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(holder.imag.context).load(dataList.get(position).url).into(holder.imag);
    }

    override fun getItemCount(): Int {
        return if (this.dataList != null)
            dataList.size
        else
            0
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imag = itemView.findViewById<ImageView>(R.id.imageview);

    }
}