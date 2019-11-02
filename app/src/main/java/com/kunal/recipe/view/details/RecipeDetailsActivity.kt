package com.kunal.recipe.view.details

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kunal.recipe.R
import com.kunal.recipe.model.Ingredient
import com.kunal.recipe.model.Recipe
import com.kunal.recipe.model.Step
import com.kunal.recipe.view.step.StepFragment
import kotlinx.android.synthetic.main.activity_recipe_details.root_details

private const val ARG_RECIPE = "ARG_RECIPE"

class RecipeDetailsActivity : AppCompatActivity(),
    RecipeDetailsFragment.OnRecipeDetailsInteractionListener {

    val recipe: Recipe by lazy { requireNotNull(intent).getParcelableExtra(ARG_RECIPE) as Recipe }

    companion object {
        fun start(context: Context, recipe: Recipe) {
            val intent = Intent(context, RecipeDetailsActivity::class.java).apply {
                putExtra(
                    ARG_RECIPE,
                    recipe
                )
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)
        supportFragmentManager.beginTransaction()
            .add(R.id.root, RecipeDetailsFragment.newInstance(recipe))
            .commit()

        root_details?.let {
            supportFragmentManager.beginTransaction()
                .add(R.id.root_details, StepFragment.newInstance(recipe.steps.first()))
                .commit()
        }
    }

    override fun showRecipeIngredients(ingredients: List<Ingredient>) {

    }

    override fun showRecipeStep(step: Step) {
        if (root_details == null)
            showRecipeStepSinglePane(step)
        else
            showRecipeStepDualPane(step)
    }

    private fun showRecipeStepSinglePane(step: Step) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.root, StepFragment.newInstance(step))
            .addToBackStack(null)
            .commit()
    }

    private fun showRecipeStepDualPane(step: Step) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.root_details, StepFragment.newInstance(step))
            .commit()
    }
}
