package com.example.project.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.R
import com.example.project.databinding.ActivityRandomDetailBinding
import com.example.project.vm.MainViewModel
import com.example.project.vm.SelectedDetailViewModel

class RandomDetailActivity : AppCompatActivity() {
    private val datasource: MainViewModel = MainViewModel()
    lateinit var binding : ActivityRandomDetailBinding
    private val viewModel : SelectedDetailViewModel = SelectedDetailViewModel(datasource)

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRandomDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val activityCategory = binding.category
        val activityDescription = binding.textDescription
        val activityPrice = binding.textLevelPrice

        intent.extras?.let { it ->
            val id = it.getInt("ACTIVITY_RANDOM")
            val currentActivity = datasource.getActivityForId(id)
            activityCategory.text = currentActivity?.activity
            activityDescription.text = currentActivity?.title
            activityPrice.text = currentActivity?.price
        }

        binding.imageArrowBack.setOnClickListener {
            finish()
        }

        binding.buttonTryAnother.setOnClickListener {
            intent.extras?.let { it ->
                val id = (0..18).random()
                val currentActivity = datasource.getActivityForId(id)
                activityCategory.text = currentActivity?.activity
                activityDescription.text = currentActivity?.title
                activityPrice.text = currentActivity?.price
            }

        }
    }

}