package com.kunal.recipe.view.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kunal.recipe.data.base.Response.Error
import com.kunal.recipe.data.base.Response.Success
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

    private var _error: MutableLiveData<Error> = MutableLiveData()

    val error: LiveData<Error>
        get() = _error

    override fun onStart() {
        super.onStart()
        viewModelScope.launch {
            val response = recipeRepository.getItems()
            if (response is Success)
                _recipeLiveData.value = response.data
            else if (response is Error)
                _error.value = response
        }
    }

}
