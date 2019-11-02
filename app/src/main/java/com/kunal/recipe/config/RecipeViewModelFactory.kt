package com.kunal.recipe.config

import android.util.ArrayMap
import androidx.lifecycle.ViewModel
import javax.inject.Inject
import androidx.lifecycle.ViewModelProvider
import com.kunal.recipe.view.recipe.RecipeViewModel
import java.util.concurrent.Callable
import javax.inject.Singleton


/**
 * Created by kunal on 2019-08-23.
 */
class RecipeViewModelFactory @Inject constructor(recipeViewModel: RecipeViewModel) :
    ViewModelProvider.Factory {

    private val creators = mutableMapOf<Class<*>, Callable<out ViewModel>>()

    init {
        // View models cannot be injected directly because they won't be bound to the owner's
        // view model scope.
        creators.put(RecipeViewModel::class.java, Callable { recipeViewModel })
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator = creators.get(modelClass)
        if (creator == null) {
            for (entry in creators.entries) {
                if (modelClass.isAssignableFrom(entry.key)) {
                    creator = entry.value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("Unknown model class $modelClass")
        }
        try {
            return creator.call() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}