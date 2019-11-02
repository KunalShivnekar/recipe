package com.kunal.recipe.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.kunal.recipe.R
import com.kunal.recipe.model.Recipe
import com.kunal.recipe.view.details.RecipeDetailsActivity
import com.kunal.recipe.view.recipe.RecipeFragment
import com.kunal.recipe.view.recipe.RecipeFragment.OnRecipeInteractionListener

class MainActivity : AppCompatActivity(), OnRecipeInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.root, RecipeFragment.newInstance())
            .commit()
    }

    override fun showRecipe(recipe: Recipe) {
        RecipeDetailsActivity.start(this, recipe)
    }
}
