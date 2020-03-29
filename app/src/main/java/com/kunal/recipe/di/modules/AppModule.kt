package com.kunal.recipe.di.modules

import androidx.lifecycle.ViewModel
import com.kunal.recipe.config.ViewModelKey
import com.kunal.recipe.view.details.RecipeDetailsFragment
import com.kunal.recipe.view.details.RecipeDetailsViewModel
import com.kunal.recipe.view.recipe.RecipeFragment
import com.kunal.recipe.view.recipe.RecipeViewModel
import com.kunal.recipe.view.step.StepFragment
import com.kunal.recipe.view.step.StepViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap


/**
 * Created by kunal on 2019-08-20.
 */
@Module//(subcomponents = [ViewComponent::class, RecipeDetailsComponent::class])
abstract class AppModule {

    @ContributesAndroidInjector(modules = [
        ViewModuleRecipe::class
    ])
    internal abstract fun recipeFragment(): RecipeFragment

    @Binds
    @IntoMap
    @ViewModelKey(RecipeViewModel::class)
    internal abstract fun bindRecipeViewModel(recipeViewModel: RecipeViewModel): ViewModel

    @ContributesAndroidInjector(modules = [
        ViewModuleRecipe::class
    ])
    internal abstract fun recipeDetailsFragment(): RecipeDetailsFragment

    @Binds
    @IntoMap
    @ViewModelKey(RecipeDetailsViewModel::class)
    internal abstract fun bindRecipeDetailsViewModel(recipeDetailsViewModel: RecipeDetailsViewModel): ViewModel

    @ContributesAndroidInjector(modules = [
        ViewModuleRecipe::class
    ])
    internal abstract fun stepFragment(): StepFragment

    @Binds
    @IntoMap
    @ViewModelKey(StepViewModel::class)
    internal abstract fun bindStepViewModel(stepViewModel: StepViewModel): ViewModel

 /*   @Binds
    @IntoMap
    @ClassKey(RecipeFragment::class)
    internal abstract fun bindRecipeFactory(factory: ViewComponent.Factory): AndroidInjector.Factory<*>

    @Binds
    @IntoMap
    @ClassKey(RecipeDetailsFragment::class)
    internal abstract fun bindYourAndroidInjectorFactory(factory: RecipeDetailsComponent.Factory): AndroidInjector.Factory<*>
*/
}