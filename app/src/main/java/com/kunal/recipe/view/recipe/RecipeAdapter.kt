package com.kunal.recipe.view.recipe

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kunal.recipe.R
import com.kunal.recipe.model.Recipe

import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.recipe_item.view.recipeImage
import kotlinx.android.synthetic.main.recipe_item.view.recipeName
import kotlinx.android.synthetic.main.recipe_item.view.recipeServings
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import com.squareup.picasso.Picasso
import java.net.URL

/**
 * Created by kunal on 2019-08-22.
 */
class RecipeAdapter(private val listener: OnRecipeSelectedListener) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    var contentList = listOf<Recipe>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.item = contentList[position]
    }

    override fun getItemCount(): Int = contentList.size

    inner class RecipeViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        var item: Recipe? = null
            set(value) {
                field = value
                value?.let {
                    view.recipeName.text = value.name
                    view.recipeServings.text =
                        view.context.getString(R.string.servings, value.servings)
                    if (value.image.isNotEmpty())
                        Picasso.get().load(value.image).placeholder(R.drawable.ic_launcher_background).into(
                            view.recipeImage
                        )
                }
            }

        init {
            view.setOnClickListener { listener.onRecipeSelected(item!!) }
        }
    }

    interface OnRecipeSelectedListener {
        fun onRecipeSelected(recipe: Recipe)
    }
}