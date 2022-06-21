package com.example.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.databinding.ActivityActivitiesListBinding
import com.example.project.databinding.ActivityItemBinding
import com.example.project.vm.MainViewModel

class ActivitiesListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityActivitiesListBinding
    private val mainViewModel: MainViewModel = MainViewModel()
    private val adapter by lazy {
        ActivityAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActivitiesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL, false)
        mainViewModel.fetchActivities()
        mainViewModel.activities.observe(this){
            if(it.isNotEmpty()) adapter.listActivities = it
        }

    }
}