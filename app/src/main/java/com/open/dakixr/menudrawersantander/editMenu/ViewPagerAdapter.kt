package com.open.dakixr.menudrawersantander.editMenu

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

private const val POS_FRAGMENT_YOUR_FEATURES = 0
private const val POS_FRAGMENT_ALL_FEATURES = 1

class ViewPagerAdapter(fragmentManager: FragmentManager, titles: ArrayList<String>) : FragmentPagerAdapter(fragmentManager) {


    private val titleNames = titles

    override fun getCount(): Int {
        //There are only 2 fragments to display YOUR_FEATURES, ALL_FEATURES
        return 2
    }

    override fun getItem(position: Int): Fragment? {

        return when(position){
            POS_FRAGMENT_YOUR_FEATURES -> FragmentYourFeatures()
            POS_FRAGMENT_ALL_FEATURES -> FragmentAllFeatures()
            else -> null
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return when(position){
            POS_FRAGMENT_YOUR_FEATURES-> titleNames[0]
            POS_FRAGMENT_ALL_FEATURES-> titleNames[1]
            else -> null
        }
    }
}