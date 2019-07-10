package com.open.dakixr.menudrawersantander.editMenu

import android.content.SharedPreferences
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.google.gson.Gson
import com.open.dakixr.menudrawersantander.R
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

        val data = Gson().toJson(FragmentYourFeatures.itemList)
        val editor = sharedPref.edit()
        editor.putString("yourFeatures", data)
        editor.apply()

        finish()

    }

}
