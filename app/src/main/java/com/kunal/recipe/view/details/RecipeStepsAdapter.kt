package com.kunal.recipe.view.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kunal.recipe.databinding.StepsItemBinding
import com.kunal.recipe.model.Step

/**
 * Created by kunal on 2019-08-22.
 */
class RecipeStepsAdapter(private val listener: OnRecipeStepSelectedListener) :
    ListAdapter<Step, RecipeStepsAdapter.RecipeStepViewHolder>(StepsDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeStepViewHolder {
        return RecipeStepViewHolder.from(parent, listener)
    }

    override fun onBindViewHolder(holder: RecipeStepViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RecipeStepViewHolder(
        private val binding: StepsItemBinding,
        listener: OnRecipeStepSelectedListener
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.clickListener = listener
        }

        fun bind(item: Step) {
            binding.viewModel = item
        }

        companion object {
            fun from(
                parent: ViewGroup,
                listener: OnRecipeStepSelectedListener
            ): RecipeStepViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = StepsItemBinding.inflate(inflater, parent, false)
                return RecipeStepViewHolder(binding, listener)
            }
        }
    }

    interface OnRecipeStepSelectedListener {
        fun onRecipeStepSelected(step: Step)
    }

    class StepsDiffCallback : DiffUtil.ItemCallback<Step>() {
        override fun areItemsTheSame(oldItem: Step, newItem: Step): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Step, newItem: Step): Boolean {
            return oldItem == newItem
        }

    }
}