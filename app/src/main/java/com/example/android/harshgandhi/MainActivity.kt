package com.example.android.harshgandhi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android.harshgandhi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setTitle("  Let's Eat")
        supportActionBar?.setIcon(R.drawable.home)

        binding.cartLogo.setOnClickListener {
            val intent: Intent = Intent(this,Rate::class.java)
            startActivity(intent)
        }

    }
}