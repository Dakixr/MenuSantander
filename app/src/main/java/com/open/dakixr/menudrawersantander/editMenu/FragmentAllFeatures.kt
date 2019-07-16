package com.open.dakixr.menudrawersantander.editMenu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.open.dakixr.menudrawersantander.R
import com.open.dakixr.menudrawersantander.menu.AccessSharedPref
import kotlinx.android.synthetic.main.fragment_edit.view.*


class FragmentAllFeatures : Fragment() {

    companion object{
        lateinit var adapterAllFeatures: DataAdapterAllFeatures
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_edit, container, false)

        val accessSharedPref = AccessSharedPref(view.context)
        val listAllFeatures = accessSharedPref.readAllFeatures()

        listAllFeatures.sort()

        view.recycler_features.layoutManager = LinearLayoutManager(view.context)
        adapterAllFeatures = DataAdapterAllFeatures(listAllFeatures)
        view.recycler_features.adapter = adapterAllFeatures

        return view
    }

}
