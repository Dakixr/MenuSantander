package com.open.dakixr.menudrawersantander.editMenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.open.dakixr.menudrawersantander.menu.ItemMenu
import java.util.ArrayList
import androidx.core.view.MotionEventCompat
import android.view.View.OnTouchListener
import android.annotation.SuppressLint
import android.view.MotionEvent.*
import com.open.dakixr.menudrawersantander.menu.TypeItemMenu


private const val ITEM_VIEWHOLDER = 0
private const val OTHER_FEATURES_VIEWHOLDER = 1


internal class DataAdapterYourFeatures(private val items: ArrayList<ItemMenu>,
                                       private val positionOtherFeatures: Int,
                                       private val dragStartListener: OnStartDragListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        items.add(positionOtherFeatures,ItemMenu(1,"Separador",232, positionOtherFeatures,false,2))
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].type == 2) OTHER_FEATURES_VIEWHOLDER else ITEM_VIEWHOLDER
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val layout = when (viewType) {
            ITEM_VIEWHOLDER -> com.open.dakixr.menudrawersantander.R.layout.item_your_features
            else -> com.open.dakixr.menudrawersantander.R.layout.item_other_features
        }

        val view = LayoutInflater.from(viewGroup.context).inflate(layout, viewGroup, false)
        return if (viewType == ITEM_VIEWHOLDER) ViewHolderItem(view) else ViewHolderOtherFeatures(view)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, i: Int) {

        if (getItemViewType(i) == ITEM_VIEWHOLDER) {

            (viewHolder as ViewHolderItem)

            viewHolder.sliderItem.setOnTouchListener(OnTouchListener { v, event ->
                if (MotionEventCompat.getActionMasked(event) == ACTION_DOWN) {
                    dragStartListener.onStartDrag(viewHolder)
                }
                false
            })

            val item = items[i]

            if (item.type != TypeItemMenu.DEFAULT.typeItemMenu) {
                viewHolder.deleteItem.setImageResource(com.open.dakixr.menudrawersantander.R.drawable.ic_func_031)
            }
            viewHolder.iconItem.setImageResource(item.itemIcon)
            viewHolder.nameItem.text = item.itemName
            viewHolder.sliderItem.setImageResource(com.open.dakixr.menudrawersantander.R.drawable.ic_sys_15)

        } else{

            if(i != items.size - 1)
                (viewHolder as ViewHolderOtherFeatures).infoTextOtherFeatures.visibility = View.GONE
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    internal inner class ViewHolderItem(view: View) : RecyclerView.ViewHolder(view) {
        var deleteItem: ImageView = view.findViewById(com.open.dakixr.menudrawersantander.R.id.delete_item)
        var iconItem: ImageView = view.findViewById(com.open.dakixr.menudrawersantander.R.id.icon_item)
        var nameItem: TextView = view.findViewById(com.open.dakixr.menudrawersantander.R.id.name_item)
        var sliderItem: ImageView = view.findViewById(com.open.dakixr.menudrawersantander.R.id.slider_item)
    }

    internal inner class ViewHolderOtherFeatures(view: View) : RecyclerView.ViewHolder(view) {
        val infoTextOtherFeatures: TextView = view.findViewById(com.open.dakixr.menudrawersantander.R.id.info_text_other_features)
    }
}