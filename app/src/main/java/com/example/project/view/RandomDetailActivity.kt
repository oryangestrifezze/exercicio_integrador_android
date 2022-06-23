package com.example.project.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.R
import com.example.project.databinding.ActivityRandomDetailBinding
import com.example.project.vm.MainViewModel
import com.example.project.vm.SelectedDetailViewModel

class RandomDetailActivity : AppCompatActivity() {
    private val datasource: MainViewModel = MainViewModel()
    lateinit var binding: ActivityRandomDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRandomDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val activityCategory = binding.category
        val activityDescription = binding.textDescription
        val activityParticipants = binding.textNumberParticipants
        val activityPrice = binding.textLevelPrice

        intent.extras?.let { it ->
            val id = it.getInt("ACTIVITY_RANDOM")
            val price = it.getString("PRICE_KEY")
            val participants = it.getInt("NUMBER_PARTICIPANTES")
            val currentActivity = datasource.getActivityForId(id)
            activityCategory.text = currentActivity?.activity
            activityDescription.text = currentActivity?.title
            activityParticipants.text = participants.toString()
            activityPrice.text = price
        }

        binding.imageArrowBack.setOnClickListener {
            finish()
        }

        binding.buttonTryAnother.setOnClickListener {
            intent.extras?.let { it ->
                val id = (0..18).random()
                val participants = it.getInt("NUMBER_PARTICIPANTES")
                val currentActivity = datasource.getActivityForId(id)
                activityCategory.text = currentActivity?.activity
                activityDescription.text = currentActivity?.title
                activityParticipants.text = participants.toString()
                activityPrice.text = currentActivity?.price
            }

        }
    }

}