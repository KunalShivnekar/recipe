package com.kunal.recipe.config

import com.kunal.recipe.di.components.DaggerAppComponent

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by kunal on 2019-08-20.
 */
class RecipeApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().build()
    }

}