package com.kunal.recipe.utility

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.kunal.recipe.R
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun ImageView.setImage(url: String) {
    if (url.isNotEmpty())
        Picasso.get().load(url).placeholder(R.drawable.ic_launcher_background).into(this)
}