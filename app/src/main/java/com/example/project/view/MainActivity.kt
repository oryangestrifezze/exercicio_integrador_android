package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project.databinding.ActivityMainBinding
import com.example.project.view.ActivitiesListActivity
import com.example.project.view.TermsAndConditionsActivity
import com.example.project.vm.MainViewModel

class MainActivity() : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonTerms.setOnClickListener {
            navTermsAndConditions()
        }

        val editText = binding.inputAppNumberOfParticipants
        editText.addTextChangedListener(EditTextListener(binding))

        binding.buttonStart.setOnClickListener {
            val participants = binding.inputAppNumberOfParticipants.text.toString()
            viewModel.start(participants)
        }

        viewModel.isValid.observe(this) { isValid ->
            if(isValid) navActivitiesView() else showMessageError()
        }
    }

    private fun navTermsAndConditions() {
        val intent = Intent(this, TermsAndConditionsActivity::class.java)
        startActivity(intent)
    }

    private fun navActivitiesView() {
        val intent = Intent(this, ActivitiesListActivity::class.java)
        startActivity(intent)
    }

    private fun showMessageError() {
        Toast.makeText(this,"Número de participantes inválido", Toast.LENGTH_LONG).show()
    }
}