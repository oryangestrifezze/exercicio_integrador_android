package com.example.project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project.model.ActivityModel
import com.example.project.databinding.ActivityItemBinding

class ActivityAdapter : RecyclerView.Adapter<ActivityAdapter.ActivityAdapterViewHolder>() {

    var listActivities: List<ActivityModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ActivityItemBinding.inflate(inflater, parent, false)
        return ActivityAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActivityAdapterViewHolder, position: Int) {
        val item = listActivities[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listActivities.size


    class ActivityAdapterViewHolder(private val binding: ActivityItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(activity: ActivityModel) {
            binding.textActivitie.text = activity.activity
        }
    }
}