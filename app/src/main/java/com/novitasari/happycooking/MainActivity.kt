package com.novitasari.happycooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class MainActivity() : AppCompatActivity(), View.OnClickListener {
    private lateinit var cvIntentT1: CardView
    private lateinit var cvIntentT2: CardView
    private lateinit var cvIntentT3: CardView
    private lateinit var cvIntentT4: CardView
    private lateinit var cvIntentT5: CardView
    private lateinit var cvIntentT6: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cvIntentT1 = findViewById(R.id.c1)
        cvIntentT1.setOnClickListener(this)
        cvIntentT2 = findViewById(R.id.c2)
        cvIntentT2.setOnClickListener(this)
        cvIntentT3 = findViewById(R.id.c3)
        cvIntentT3.setOnClickListener(this)
        cvIntentT4 = findViewById(R.id.c4)
        cvIntentT4.setOnClickListener(this)
        cvIntentT5 = findViewById(R.id.c5)
        cvIntentT5.setOnClickListener(this)
        cvIntentT6 = findViewById(R.id.c6)
        cvIntentT6.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.c1 -> {
                val intentT1 = Intent(this@MainActivity, Trending1::class.java)
                startActivity(intentT1)
            }
            R.id.c2 -> {
                val intentT2 = Intent(this@MainActivity, Trending2::class.java)
                startActivity(intentT2)
            }
            R.id.c3 -> {
                val intentT3 = Intent(this@MainActivity, Rec1::class.java)
                startActivity(intentT3)
            }
            R.id.c4 -> {
                val intentT4 = Intent(this@MainActivity, Rec2::class.java)
                startActivity(intentT4)
            }
            R.id.c5 -> {
                val intentT5 = Intent(this@MainActivity, Meat1::class.java)
                startActivity(intentT5)
            }
            R.id.c6 -> {
                val intentT6 = Intent(this@MainActivity, Meat2::class.java)
                startActivity(intentT6)
            }
        }


    }
}