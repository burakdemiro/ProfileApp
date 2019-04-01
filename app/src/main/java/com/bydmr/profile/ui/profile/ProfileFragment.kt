package com.bydmr.profile.ui.profile

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.bydmr.profile.databinding.ProfileFragmentBinding
import com.bydmr.profile.provider.CoroutineFragment
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class ProfileFragment : CoroutineFragment(), KodeinAware {
    override val kodein by kodein()
    private val profileViewModelFactory: ProfileFragmentViewModelFactory by instance()

    private lateinit var binding: ProfileFragmentBinding
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = ProfileFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, profileViewModelFactory).get(ProfileViewModel::class.java)
        binding.setLifecycleOwner { this@ProfileFragment.lifecycle }
        setupUi()
    }

    fun setupUi() = launch {
        val member = viewModel.member.await()
        val followers = viewModel.followers.await()
        val movies = viewModel.movies.await()

        member.observe(this@ProfileFragment, Observer { member ->
            // fragmentText.text = member.toString()
            binding.memberInfo = member.result
        })

        followers.observe(this@ProfileFragment, Observer { followers ->
            binding.followers = followers
        })

        movies.observe(this@ProfileFragment, Observer { movies ->
            binding.movies = movies
            Log.i("etiket", "$movies")
        })
    }

}
