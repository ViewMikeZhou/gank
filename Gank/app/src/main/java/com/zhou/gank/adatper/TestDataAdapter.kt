package com.zhou.gank.adatper

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.zhou.gank.R
import org.jetbrains.anko.find

/**
 * Created by zhou on 2017/10/25.
 */
class TestDataAdapter(var dataList: ArrayList<String>) : RecyclerView.Adapter<TestDataAdapter.MyViewHolder>() {

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.tv?.setText(dataList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.test_data_item, parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


    inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tv = itemView?.find<TextView>(R.id.tv_item)
    }
}