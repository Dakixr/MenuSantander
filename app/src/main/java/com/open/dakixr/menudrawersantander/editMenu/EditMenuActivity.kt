package com.open.dakixr.menudrawersantander.editMenu

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.gson.Gson
import com.open.dakixr.menudrawersantander.R
import com.open.dakixr.menudrawersantander.editMenu.FragmentYourFeatures.Companion.itemList
import com.open.dakixr.menudrawersantander.menu.ItemMenu
import kotlinx.android.synthetic.main.activity_edit_menu.*

class EditMenuActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        setContentView(R.layout.activity_edit_menu)

        val titles = arrayListOf<String>()
        titles.add(getString(R.string.your_features))
        titles.add(getString(R.string.all_features))

        val adapter = ViewPagerAdapter(supportFragmentManager,titles)
        pager.adapter = adapter

        tabs.setupWithViewPager(pager)

    }

    fun cancelButton(view: View){
        finish()
    }

    fun doneButton(view: View){

        val sharedPref: SharedPreferences = getSharedPreferences("features", 0) //Private mode

        removeSeparator(itemList)

        val data = Gson().toJson(itemList)
        val editor = sharedPref.edit()
        editor.putString("yourFeatures", data)
        editor.apply()

        finish()

    }

    private fun removeSeparator(list: ArrayList<ItemMenu>) {

        var i = 0
        while(i < list.size){

            if(list[i].type == 2)
                list.removeAt(i)
            else i++
        }

    }

}
