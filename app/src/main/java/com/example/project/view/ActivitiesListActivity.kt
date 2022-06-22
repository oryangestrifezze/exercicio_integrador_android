package com.example.project.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.ActivityAdapter
import com.example.project.databinding.ActivityActivitiesListBinding
import com.example.project.model.ActivityModel
import com.example.project.vm.MainViewModel

class ActivitiesListActivity : AppCompatActivity() {
    val ACTIVITY_ID = "ID_ACTIVITY"

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
        startActivity(intent)
    }
}