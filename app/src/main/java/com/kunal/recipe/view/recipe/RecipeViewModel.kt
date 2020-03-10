package com.kunal.recipe.view.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kunal.recipe.data.base.Response
import com.kunal.recipe.data.recipe.RecipeRepository
import com.kunal.recipe.model.Recipe
import com.kunal.recipe.view.base.BaseViewModelImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class RecipeViewModel @Inject constructor(private val recipeRepository: RecipeRepository) :
    BaseViewModelImpl() {

    private var _recipeLiveData: MutableLiveData<List<Recipe>> = MutableLiveData()

    val recipeLiveData: LiveData<List<Recipe>>
        get() = _recipeLiveData

    val error: LiveData<Response>
        get() = recipeRepository.error

    override fun onCreate() {
        super.onCreate()
        viewModelScope.launch {
            _recipeLiveData.value = recipeRepository.getItems().value
        }
    }

}
