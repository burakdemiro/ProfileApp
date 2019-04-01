package com.bydmr.profile.ui.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bydmr.profile.data.network.response.followers.FollowersResponse
import com.bydmr.profile.databinding.ItemFollowersBinding


class ProfileFragmentAdapter(
        val followers: FollowersResponse
): RecyclerView.Adapter<ProfileFragmentAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemFollowersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return followers.result.itemCount
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.followersInfo = followers.result.items[position]
        holder.binding.executePendingBindings()
    }

    inner class Holder(var binding: ItemFollowersBinding): RecyclerView.ViewHolder(binding.root)
}
