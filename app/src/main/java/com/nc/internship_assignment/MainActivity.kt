package com.nc.internship_assignment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn = findViewById<AppCompatButton>(R.id.btn)
        btn.setOnClickListener {
            Log.d("","button Click================")
            var Intent = Intent(this@MainActivity, showImagesActivity::class.java);
            startActivity(intent)

        }
    }
}