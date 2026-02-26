package com.example.denislab2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "ЛР №2 – Ткаченко Денис"

        findViewById<android.widget.Button>(R.id.btnTask2).setOnClickListener {
            startActivity(Intent(this, Task2Activity::class.java))
        }
        findViewById<android.widget.Button>(R.id.btnTask3).setOnClickListener {
            startActivity(Intent(this, Task3Activity::class.java))
        }
        findViewById<android.widget.Button>(R.id.btnFig5).setOnClickListener {
            startActivity(Intent(this, Fig5Activity::class.java))
        }
        findViewById<android.widget.Button>(R.id.btnFig8).setOnClickListener {
            startActivity(Intent(this, Fig8Activity::class.java))
        }
        findViewById<android.widget.Button>(R.id.btnGrid).setOnClickListener {
            startActivity(Intent(this, GridActivity::class.java))
        }
        findViewById<android.widget.Button>(R.id.btnGridSpan).setOnClickListener {
            startActivity(Intent(this, GridSpanActivity::class.java))
        }
        findViewById<android.widget.Button>(R.id.btnLetterN).setOnClickListener {
            startActivity(Intent(this, LetterNActivity::class.java))
        }
    }
}

