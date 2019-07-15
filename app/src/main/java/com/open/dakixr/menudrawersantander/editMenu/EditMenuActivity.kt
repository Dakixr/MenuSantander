package com.open.dakixr.menudrawersantander.editMenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.open.dakixr.menudrawersantander.R
import com.open.dakixr.menudrawersantander.menu.AccessSharedPref
import com.open.dakixr.menudrawersantander.menu.ItemMenu
import kotlinx.android.synthetic.main.activity_edit_menu.*
import android.graphics.Typeface
import android.widget.TextView
import android.view.ViewGroup





class EditMenuActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_menu)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        val adapter = ViewPagerAdapter(supportFragmentManager,this)
        pager.adapter = adapter

        tabs.setupWithViewPager(pager)
        tabs.setTabTextColors(getColor(R.color.medium_grey), getColor(R.color.dark_grey))
    }

    fun cancelButton(view: View){
        finish()
    }

    fun doneButton(view: View){

        //Update internal position in ItemMenu
        var i = 0
        DataAdapterYourFeatures.listYourFeatures.forEach {
            it.position = i++
        }

        val accessSharedPref = AccessSharedPref(this)
        accessSharedPref.writePosOtherFeatures(ItemMenu.removeSeparator(DataAdapterYourFeatures.listYourFeatures))
        accessSharedPref.writeAllFeatures(DataAdapterAllFeatures.listAllFeatures)
        accessSharedPref.writeYourFeatures(DataAdapterYourFeatures.listYourFeatures)


        finish()
    }

}
