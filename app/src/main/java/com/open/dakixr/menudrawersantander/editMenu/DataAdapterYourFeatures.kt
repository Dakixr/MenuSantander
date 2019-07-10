package com.open.dakixr.menudrawersantander.editMenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.open.dakixr.menudrawersantander.R
import com.open.dakixr.menudrawersantander.menu.ItemMenu
import java.util.ArrayList


internal class DataAdapterYourFeatures(private val names: ArrayList<ItemMenu>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(viewGroup.context).inflate(com.open.dakixr.menudrawersantander.R.layout.item_your_features, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {

        if(names[i].type != 0) {
            (viewHolder as ViewHolder).deleteItem.setImageResource(com.open.dakixr.menudrawersantander.R.drawable.ic_func_031)
        }

        (viewHolder as ViewHolder).iconItem.setImageResource(names[i].itemIcon)
        viewHolder.nameItem.text = names[i].itemName
        viewHolder.sliderItem.setImageResource(com.open.dakixr.menudrawersantander.R.drawable.ic_sys_15)

    }

    override fun getItemCount(): Int {
        return names.size
    }

    internal inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var deleteItem: ImageView
        var iconItem: ImageView
        var nameItem: TextView
        var sliderItem: ImageView

        init {

            deleteItem = view.findViewById(R.id.delete_item)
            iconItem = view.findViewById(R.id.icon_item)
            nameItem = view.findViewById(R.id.name_item)
            sliderItem = view.findViewById(R.id.slider_item)

        }
    }
}

