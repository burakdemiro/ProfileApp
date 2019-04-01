package com.bydmr.profile.databindings

import android.widget.LinearLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bydmr.profile.data.network.response.followers.FollowersResponse
import com.bydmr.profile.data.network.response.movies.MoviesResponse
import com.bydmr.profile.ui.profile.adapter.MoviesRecyclerAdapter
import com.bydmr.profile.ui.profile.adapter.FollowersRecyclerAdapter

object RecyclerViewBindingAdapter {

    @JvmStatic
    @BindingAdapter("setFollowers")
    fun loadFollowers(recyclerView: RecyclerView, followers: FollowersResponse?) {

        if (followers == null) return

        val layoutManager = LinearLayoutManager(recyclerView.context, LinearLayout.HORIZONTAL, false)
        if (recyclerView.layoutManager == null)
            recyclerView.layoutManager = layoutManager

        val adapter = FollowersRecyclerAdapter(followers)
        if (recyclerView.adapter == null)
            recyclerView.adapter = adapter
    }

    @JvmStatic
    @BindingAdapter("setMovies")
    fun loadMovies(recyclerView: RecyclerView, movies: MoviesResponse?) {

        if (movies == null) return

        val layoutManager = GridLayoutManager(recyclerView.context, 2, GridLayoutManager.HORIZONTAL, false)
        if (recyclerView.layoutManager == null)
            recyclerView.layoutManager = layoutManager

        val adapter = MoviesRecyclerAdapter(movies)
        if (recyclerView.adapter == null)
            recyclerView.adapter = adapter
    }
}
