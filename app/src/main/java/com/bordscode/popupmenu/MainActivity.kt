package com.bordscode.popupmenu

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.PopupMenu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView_options.setOnClickListener {
            val popupMenu = PopupMenu(this, it)
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu_open_facebook -> {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/m1chelle.aca"))
                        startActivity(intent)
                        true
                    }
                    R.id.menu_open_twitter -> {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/MichaiAca"))
                        startActivity(intent)
                        true
                    }
                    R.id.menu_open_github -> {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/MichAca"))
                        startActivity(intent)
                        true
                    }

                    R.id.menu_show_toast -> {
                        Toast.makeText(this, "Hello Mich!", Toast.LENGTH_LONG).show()
                        true
                    }

                    else -> false
                }
            }

            popupMenu.inflate(R.menu.menu_main)

            //showing the icon in the ellipsis

            try {
                val fieldMpop = PopupMenu::class.java.getDeclaredField("mPopup")
                fieldMpop.isAccessible = true
                val mPopup = fieldMpop.get(popupMenu)
                mPopup.javaClass
                    .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                    .invoke(mPopup, true)
            } catch (e: Exception) {
                Log.e("Main", "Error showing menu icons")
            } finally {
                popupMenu.show()
            }

        }


    }
}
