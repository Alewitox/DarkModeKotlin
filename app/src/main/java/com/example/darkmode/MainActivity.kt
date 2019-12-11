package com.example.darkmode

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var eyp: Switch? = null
    internal lateinit var sharedpref: Sharedpref

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedpref = Sharedpref(this)
        if (sharedpref.loadNightModeState() == true) {
            setTheme(R.style.darkTheme)
        } else
            setTheme(R.style.AppTheme)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eyp = findViewById<View>(R.id.myswitch) as Switch?
        if (sharedpref.loadNightModeState() == true) {
            eyp!!.isChecked = true
        }
        eyp!!.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                sharedpref.setNightModeState(true)
                restartApp()
            } else {
                sharedpref.setNightModeState(false)
                restartApp()
            }
        }
        }

        fun restartApp() {
            val i = Intent(getApplicationContext(), MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }




