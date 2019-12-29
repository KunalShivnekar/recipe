package com.kunal.recipe.view.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kunal.recipe.data.base.Response
import com.kunal.recipe.data.recipe.RecipeRepository
import com.kunal.recipe.model.Recipe
import com.kunal.recipe.view.base.BaseViewModelImpl
import javax.inject.Inject

class RecipeViewModel @Inject constructor(private val recipeRepository: RecipeRepository) :
    BaseViewModelImpl() {

    private var recipeLiveData: MutableLiveData<List<Recipe>> = MutableLiveData()

    override fun onCreate() {
        super.onCreate()
        val data = recipeRepository.getItems()
        data.observeForever {
            recipeLiveData.value = it
        }
    }

    fun getRecipe(): LiveData<List<Recipe>> = recipeLiveData

    fun getError(): LiveData<Response> = recipeRepository.error
}
