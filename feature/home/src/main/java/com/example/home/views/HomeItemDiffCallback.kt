package com.example.home.views

import androidx.recyclerview.widget.DiffUtil
import com.example.model.User

class HomeItemDiffCallback(private val oldList: List<User>,
                           private val newList: List<User>) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int)
            = oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
                && oldList[oldItemPosition].avatar_url == newList[newItemPosition].avatar_url
                && oldList[oldItemPosition].name == newList[newItemPosition].name
    }
}