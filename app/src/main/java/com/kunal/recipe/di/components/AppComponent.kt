package com.kunal.recipe.di.components

import com.kunal.recipe.config.RecipeApplication
import com.kunal.recipe.di.modules.AppModule
import com.kunal.recipe.di.modules.DataModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by kunal on 2019-08-20.
 */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, DataModule::class])
interface AppComponent : AndroidInjector<RecipeApplication>{

    @Component.Builder
    interface Builder {

        fun build(): AppComponent
    }
}