package com.novitasari.happycooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class MainActivity() : AppCompatActivity(), View.OnClickListener{
    private lateinit var cvIntentT1: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cvIntentT1 = findViewById(R.id.c1)
        cvIntentT1.setOnClickListener(this)

    }
    override fun onClick(v: View) {
        when(v.id){
            R.id.c1 ->{
                val intentT1 = Intent (this@MainActivity, Trending1::class.java)
                startActivity(intentT1)
            }
        }
    }



}