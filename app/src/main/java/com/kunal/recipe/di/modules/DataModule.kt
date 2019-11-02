package com.kunal.recipe.di.modules

import com.kunal.recipe.data.recipe.RecipeRepository
import com.kunal.recipe.data.recipe.RecipeRepositoryImpl
import com.kunal.recipe.data.recipe.RemoteDataSource
import com.kunal.recipe.data.recipe.RemoteDataSourceImpl
import com.kunal.recipe.di.components.ViewComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by kunal on 2019-08-20.
 */
@Module(subcomponents = [ViewComponent::class])
class DataModule {

    @Singleton
    @Provides
    fun getRecipeRepository(recipeRepositoryImpl: RecipeRepositoryImpl): RecipeRepository =
        recipeRepositoryImpl

    @Provides
    fun getRecipeRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource =
        remoteDataSourceImpl

}