package com.example.project.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.ActivityAdapter
import com.example.project.databinding.ActivityActivitiesListBinding
import com.example.project.model.ActivityModel
import com.example.project.vm.MainViewModel

class ActivitiesListActivity : AppCompatActivity() {
    val ACTIVITY_ID = "ID_ACTIVITY"
    val ACTIVITY_CATEGORY = "ACTIVITY_CATEGORY"
    val ACTIVITY_RANDOM = "ACTIVITY_RANDOM"

    private  lateinit var binding: ActivityActivitiesListBinding
    private val startViewModel: MainViewModel = MainViewModel()

    private val adapter by lazy { ActivityAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityActivitiesListBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter.itemClicked = ActivityAdapter.onClick { it
            adapterOnClick(it)
        }

        startViewModel.getActivityList()

        startViewModel.activities.observe(this) {
            if (it.isNotEmpty()) {
                adapter.listActivities = it
            }
        }
    }

    private fun adapterOnClick(activity: ActivityModel) {
        val intent = Intent(this, CategoryDetailActivity()::class.java)
        intent.putExtra(ACTIVITY_ID, activity.id)
        intent.putExtra(ACTIVITY_CATEGORY, activity.activity)
        startActivity(intent)
    }

    //TODO: add essa funcao ao click do random
    private fun randomOnClick() {
        val intent = Intent(this, RandomDetailActivity()::class.java)
        val randomId  = (0..18).random()
        intent.putExtra(ACTIVITY_RANDOM, randomId)
        startActivity(intent)
    }
}