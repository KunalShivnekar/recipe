package com.kunal.recipe.config

import android.app.Application
import com.kunal.recipe.di.components.AppComponent
import com.kunal.recipe.di.components.DaggerAppComponent
import com.kunal.recipe.di.components.DataComponent

/**
 * Created by kunal on 2019-08-20.
 */
class RecipeApplication : Application() {

    lateinit var appComponent: AppComponent

    lateinit var dataComponent: DataComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .build()

        appComponent.inject(this)

        dataComponent = appComponent.dataComponentBuilder.build()
    }
}