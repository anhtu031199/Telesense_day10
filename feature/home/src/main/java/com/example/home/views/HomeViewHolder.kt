package com.example.home.views

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.home.HomeViewModel
import com.example.home.databinding.ItemHomeBinding
import com.example.model.User

class HomeViewHolder(parent: View): RecyclerView.ViewHolder(parent) {

    private val binding = ItemHomeBinding.bind(parent)

    fun bindTo(user: User, viewModel: HomeViewModel) {
        binding.user = user
        binding.viewmodel = viewModel
    }
}