package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

       binding.buttonTerms.setOnClickListener {
         navTermsAndConditions()
        }
    }

    private fun navTermsAndConditions() {
        val intent = Intent(this, TermsAndConditions::class.java)
        startActivity(intent)
    }


}