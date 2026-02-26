package com.example.denislab2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class GridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)
        title = "Задание 4 – GridLayout 3×3"
    }
}
