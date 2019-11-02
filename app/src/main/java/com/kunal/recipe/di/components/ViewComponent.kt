package com.kunal.recipe.di.components

import com.kunal.recipe.di.modules.ViewModuleRecipe
import com.kunal.recipe.di.modules.ViewModuleScans
import com.kunal.recipe.di.modules.ViewModuleVariables
import com.kunal.recipe.view.recipe.RecipeFragment
import dagger.Subcomponent

/**
 * Created by kunal on 2019-08-20.
 */
@Subcomponent(modules = [ViewModuleRecipe::class, ViewModuleScans::class, ViewModuleVariables::class])
interface ViewComponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): ViewComponent
    }

    fun inject(recipeFragment: RecipeFragment)
}