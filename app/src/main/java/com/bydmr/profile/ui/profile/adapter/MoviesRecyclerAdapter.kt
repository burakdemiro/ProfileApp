package com.bydmr.profile.ui.profile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bydmr.profile.data.network.response.movies.MoviesResponse
import com.bydmr.profile.databinding.ItemMovieBinding

class MoviesRecyclerAdapter(
        val movies: MoviesResponse
): RecyclerView.Adapter<MoviesRecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return movies.result.itemCount
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.moviesInfo = movies.result.items[position]
        holder.binding.executePendingBindings()
    }

    inner class Holder(var binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root)
}