package com.byfitnation.caloriecounter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.byfitnation.caloriecounter.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.barProfileButton.setOnClickListener {
            Toast.makeText(this, "profile clicked" , Toast.LENGTH_SHORT).show()
        }

        binding.barReportsButton.setOnClickListener {
            startActivity(Intent(this, ReportsActivity::class.java))
        }


    }


}