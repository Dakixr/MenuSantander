package com.open.dakixr.menudrawersantander.editMenu


import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import com.open.dakixr.menudrawersantander.R
import com.open.dakixr.menudrawersantander.menu.DataAdapter
import com.open.dakixr.menudrawersantander.menu.ItemMenu
import kotlinx.android.synthetic.main.activity_edit_menu.*
import kotlinx.android.synthetic.main.fragment_edit.*
import kotlinx.android.synthetic.main.fragment_edit.view.*
import kotlinx.android.synthetic.main.fragment_edit.view.recycler_features
import java.util.*
import kotlin.collections.ArrayList


class FragmentYourFeatures : Fragment() {

    companion object{
        lateinit var itemList: ArrayList<ItemMenu>
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_edit, container, false)

        val groupListType = object : TypeToken<ArrayList<ItemMenu>>() {}.type

        val sharedPref: SharedPreferences = activity!!.getSharedPreferences("features", 0) //Private mode
        itemList = Gson().fromJson(sharedPref.getString("yourFeatures", ""), groupListType)

        itemList.sort()

        view.recycler_features.layoutManager = LinearLayoutManager(view.context)
        var mAdapter = DataAdapterYourFeatures(itemList)
        view.recycler_features.adapter = mAdapter

        val helper = ItemTouchHelper(object: ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN,0){

            override fun isLongPressDragEnabled(): Boolean {
                return false
            }


            override fun onMove(recyclerView: RecyclerView, dragged: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {

                val posDragged = dragged.adapterPosition
                val posTarget = target.adapterPosition

                Collections.swap(itemList,posDragged,posTarget)
                mAdapter!!.notifyItemMoved(posDragged,posTarget)

                var i = 0
                itemList.forEach {
                    it.position = i++
                }

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}
        })

        helper.attachToRecyclerView(view.recycler_features)

        return view
    }


}
