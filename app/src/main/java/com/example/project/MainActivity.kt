package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project.databinding.ActivityMainBinding
import com.example.project.vm.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonTerms.setOnClickListener {
            navTermsAndConditions()
        }

        binding.buttonStart.setOnClickListener {
            val participants = binding.inputAppNumberOfParticipants.text.toString()
            viewModel.start(participants)
        }
        viewModel.isValid.observe(this) { isValid ->
            if(isValid) navActivitiesList() else showMessageError()

        }
    }

    private fun navTermsAndConditions() {
        val intent = Intent(this, TermsAndConditions::class.java)
        startActivity(intent)
    }

    private fun showMessageError() {
        Toast.makeText(this, "Número de participantes inválido", Toast.LENGTH_LONG).show()
    }

    private fun navActivitiesList() {
        val intent = Intent(this, ActivitiesListActivity::class.java)
        startActivity(intent)
    }


}