package com.kunal.recipe.view.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kunal.recipe.databinding.RecipeItemBinding
import com.kunal.recipe.model.Recipe

/**
 * Created by kunal on 2019-08-22.
 */
class RecipeAdapter(private val listener: OnRecipeSelectedListener) :
    ListAdapter<Recipe, RecipeAdapter.RecipeViewHolder>(RecipeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        return RecipeViewHolder.from(parent, listener)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RecipeViewHolder(
        private val binding: RecipeItemBinding,
        listener: OnRecipeSelectedListener
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.clickListener = listener
        }

        fun bind(item: Recipe) {
            binding.viewModel = item
        }

        companion object {
            fun from(parent: ViewGroup, listener: OnRecipeSelectedListener): RecipeViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RecipeItemBinding.inflate(inflater, parent, false)
                return RecipeViewHolder(binding, listener)
            }
        }
    }

    interface OnRecipeSelectedListener {
        fun onRecipeSelected(recipe: Recipe)
    }

    class RecipeDiffCallback : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem == newItem
        }
    }
}

