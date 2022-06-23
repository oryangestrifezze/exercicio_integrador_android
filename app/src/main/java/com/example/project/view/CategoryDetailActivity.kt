package com.example.project.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.PreferencesApplication.Companion.preferences
import com.example.project.vm.MainViewModel
import com.example.project.vm.SelectedDetailViewModel
import com.example.project.databinding.ActivityCategoryDetailBinding


class CategoryDetailActivity : AppCompatActivity() {
    private val datasource: MainViewModel = MainViewModel()
    lateinit var binding: ActivityCategoryDetailBinding
    private val viewModel: SelectedDetailViewModel = SelectedDetailViewModel(datasource)

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCategoryDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val activityCategory = binding.textActivityTitle
        val activityDescription = binding.textDescription
        val activityPrice = binding.textLevelPrice
        val activityParticipants = binding.textNumberParticipants

        intent.extras?.let { it ->
            val id = it.getInt("ID_ACTIVITY")
            val price = it.getString("PRICE_KEY")
            val participants = it.getInt("NUMBER_PARTICIPANTES")
            val currentActivity = datasource.getActivityForId(id)
            activityCategory.text = currentActivity?.activity
            activityDescription.text = currentActivity?.title
            activityParticipants.text = preferences.getParticipants().toString()
            activityPrice.text = price
        }

        binding.imageArrowBack.setOnClickListener {
            finish()
        }

        binding.buttonTryAnother.setOnClickListener {
            intent.extras?.let { it ->
                val id = it.getInt("ID_ACTIVITY")
                val category = it.getString("ACTIVITY_CATEGORY")
                val price = it.getString("PRICE_KEY")
                //val participants = it.getInt("NUMBER_PARTICIPANTES")
                val currentActivity = datasource.getActivityForCategory(id, category)
                activityCategory.text = currentActivity?.activity
                activityDescription.text = currentActivity?.title
                activityParticipants.text = preferences.getParticipants().toString()
                activityPrice.text = price
            }

        }
    }

}