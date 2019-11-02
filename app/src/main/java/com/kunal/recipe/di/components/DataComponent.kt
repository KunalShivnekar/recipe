package com.kunal.recipe.di.components

import com.kunal.recipe.di.modules.DataModule
import dagger.Subcomponent
import javax.inject.Singleton

/**
 * Created by kunal on 2019-08-20.
 */
@Singleton
@Subcomponent(modules = [DataModule::class])
interface DataComponent {

    @Subcomponent.Builder
    interface Builder {

        fun build(): DataComponent

    }

    val viewComponentBuilder: ViewComponent.Builder
}