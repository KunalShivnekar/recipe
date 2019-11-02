package com.kunal.recipe.view.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kunal.recipe.R
import com.kunal.recipe.model.Step
import kotlinx.android.synthetic.main.steps_item.view.name

/**
 * Created by kunal on 2019-08-22.
 */
class RecipeStepsAdapter(private val listener: OnRecipeStepSelectedListener) :
    RecyclerView.Adapter<RecipeStepsAdapter.RecipeStepViewHolder>() {

    var contentList = listOf<Step>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeStepViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.steps_item, parent, false)
        return RecipeStepViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeStepViewHolder, position: Int) {
        holder.item = contentList[position]
    }

    override fun getItemCount(): Int = contentList.size

    inner class RecipeStepViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        var item: Step? = null
            set(value) {
                field = value
                view.name.text = value?.shortDescription
            }

        init {
            view.setOnClickListener { listener.onRecipeStepSelected(item!!) }
        }
    }

    interface OnRecipeStepSelectedListener {
        fun onRecipeStepSelected(step: Step)
    }
}