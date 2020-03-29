package com.kunal.recipe.di.modules

import androidx.lifecycle.ViewModelProvider
import com.kunal.recipe.config.RecipeViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * Created by kunal on 2019-08-20.
 */
@Module
internal abstract class ViewModuleRecipe {

    @Binds
    internal abstract fun getRecipeViewModelFactory(recipeViewModelFactory: RecipeViewModelFactory): ViewModelProvider.Factory
}