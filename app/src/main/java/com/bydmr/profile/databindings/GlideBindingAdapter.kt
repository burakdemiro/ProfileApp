package com.bydmr.profile.databindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object GlideBindingAdapter {

    @JvmStatic
    @BindingAdapter("setImageWithGlide")
    fun setGlide(imageView: ImageView, url: String?) {

        Glide.with(imageView.context)
                .load(url)
                .into(imageView)
    }
}