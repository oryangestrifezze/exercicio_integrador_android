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
            if (isValid) navActivitiesView() else showMessageError()
        }
    }

    private fun navTermsAndConditions() {
        val intent = Intent(this, TermsAndConditionsActivity::class.java)
        startActivity(intent)
    }

    private fun navActivitiesView() {
        calculatePrice()
    }

    private fun showMessageError() {
        Toast.makeText(this, "Número de participantes inválido", Toast.LENGTH_LONG).show()
    }

    fun calculatePrice() {
        val free = "Free"
        val low = "Low"
        val medium = "Medium"
        val high = "High"

        val PRICE_KEY = "PRICE_KEY"
        val NUMBER_PARTICIPANTES = "NUMBER_PARTICIPANTES"
        var price: String? = free
        val numberOfParticipants = binding.inputAppNumberOfParticipants.text.toString().toInt()

        if (numberOfParticipants == 0) price = free
        else if (numberOfParticipants < 3) price = low
        else if (numberOfParticipants < 6) price = medium
        else if (numberOfParticipants > 6) price = high

        val intent = Intent(this, ActivitiesListActivity()::class.java)
        intent.putExtra(PRICE_KEY, price)
        intent.putExtra(NUMBER_PARTICIPANTES, numberOfParticipants)
        startActivity(intent)
    }
}