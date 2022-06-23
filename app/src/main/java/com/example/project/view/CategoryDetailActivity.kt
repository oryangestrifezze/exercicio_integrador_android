package com.example.project.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.vm.MainViewModel
import com.example.project.vm.SelectedDetailViewModel
import com.example.project.databinding.ActivityCategoryDetailBinding


class CategoryDetailActivity : AppCompatActivity() {
        private val datasource: MainViewModel = MainViewModel()
        lateinit var binding : ActivityCategoryDetailBinding
        private val viewModel : SelectedDetailViewModel = SelectedDetailViewModel(datasource)

        override fun onCreate(savedInstanceState: Bundle?) {
            binding = ActivityCategoryDetailBinding.inflate(layoutInflater)
            super.onCreate(savedInstanceState)
            setContentView(binding.root)


            val activityCategory = binding.textActivityTitle
            val activityDescription = binding.textDescription
            val activityPrice = binding.textLevelPrice

            intent.extras?.let { it ->
                val id = it.getInt("ID_ACTIVITY")
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
                    val id = it.getInt("ID_ACTIVITY")
                    val category = it.getString("ACTIVITY_CATEGORY")
                    val currentActivity = datasource.getActivityForCategory(id, category)
                    activityCategory.text = currentActivity?.activity
                    activityDescription.text = currentActivity?.title
                    activityPrice.text = currentActivity?.price
                }

            }
        }

    }