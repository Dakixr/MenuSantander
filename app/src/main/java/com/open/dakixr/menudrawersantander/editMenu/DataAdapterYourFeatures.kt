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


private const val ITEM_VIEWHOLDER = 0
private const val OTHER_FEATURES_VIEWHOLDER = 1


internal class DataAdapterYourFeatures(private val names: ArrayList<ItemMenu>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var POSITION_OTHER_FEATURES = 4

    init {
        names.add(POSITION_OTHER_FEATURES,ItemMenu(1,"Separador",232,POSITION_OTHER_FEATURES,false,2))
    }

    override fun getItemViewType(position: Int): Int {
        return if (names[position].type==2) OTHER_FEATURES_VIEWHOLDER else ITEM_VIEWHOLDER
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layout = when (viewType) {
            ITEM_VIEWHOLDER -> R.layout.item_your_features
            else -> R.layout.item_other_features
        }

        val view = LayoutInflater.from(viewGroup.context).inflate(layout, viewGroup, false)
        return if (viewType == ITEM_VIEWHOLDER) ViewHolderItem(view) else ViewHolderOtherFeatures(view)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {

        if (getItemViewType(i) == 0) {

            (viewHolder as ViewHolderItem)

            if (names[i].type != 0) {
                viewHolder.deleteItem.setImageResource(R.drawable.ic_func_031)
            }
            viewHolder.iconItem.setImageResource(names[i].itemIcon)
            viewHolder.nameItem.text = names[i].itemName
            viewHolder.sliderItem.setImageResource(R.drawable.ic_sys_15)
        }
    }
    override fun getItemCount(): Int {
        return names.size
    }

    internal inner class ViewHolderItem(view: View) : RecyclerView.ViewHolder(view) {
        var deleteItem: ImageView = view.findViewById(R.id.delete_item)
        var iconItem: ImageView = view.findViewById(R.id.icon_item)
        var nameItem: TextView = view.findViewById(R.id.name_item)
        var sliderItem: ImageView = view.findViewById(R.id.slider_item)
    }

    internal inner class ViewHolderOtherFeatures(view: View) : RecyclerView.ViewHolder(view)
}