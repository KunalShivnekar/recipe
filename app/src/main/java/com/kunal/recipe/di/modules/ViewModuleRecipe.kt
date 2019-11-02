package com.kunal.recipe.di.modules

import androidx.lifecycle.ViewModelProvider
import com.kunal.recipe.config.RecipeViewModelFactory
import dagger.Module
import dagger.Provides

/**
 * Created by kunal on 2019-08-20.
 */
@Module
class ViewModuleRecipe {

    @Provides
    fun getRecipeViewModelFactory(recipeViewModelFactory: RecipeViewModelFactory): ViewModelProvider.Factory =
        recipeViewModelFactory

}