package com.kunal.recipe.view.recipe

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData


import com.kunal.recipe.base.BaseUnitTest
import com.kunal.recipe.data.recipe.RecipeRepository
import com.kunal.recipe.model.Recipe
import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.junit.*
import org.junit.rules.*

/**
 * Created by kunal on 2019-08-23.
 */
class RecipeViewModelTest : BaseUnitTest() {

    private lateinit var recipeViewModel: RecipeViewModel

    @MockK
    private lateinit var recipeRepository: RecipeRepository

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    override fun setup() {
        super.setup()
        MockKAnnotations.init(this)
        recipeViewModel = RecipeViewModel(recipeRepository)
    }

    @Test
    fun onCreate() {
        every { recipeRepository.getItems() } answers {
            MutableLiveData<List<Recipe>>()
        }

        recipeViewModel.onCreate()

        verify(exactly = 1) { recipeRepository.getItems() }
    }
}