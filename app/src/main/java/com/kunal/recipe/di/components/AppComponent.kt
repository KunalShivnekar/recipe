package com.kunal.recipe.di.components

import com.kunal.recipe.config.RecipeApplication
import com.kunal.recipe.di.modules.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by kunal on 2019-08-20.
 */
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
    }

    val dataComponentBuilder: DataComponent.Builder

    fun inject(recipeApplication: RecipeApplication)
}