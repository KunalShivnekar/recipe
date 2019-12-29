package com.kunal.recipe.di.modules

import com.kunal.recipe.data.recipe.*
import com.kunal.recipe.di.components.ViewComponent
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by kunal on 2019-08-20.
 */
@Module(subcomponents = [ViewComponent::class])
class DataModule {

    @Provides
    fun getRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://d17h27t6h515a5.cloudfront.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getRecipeRepository(recipeRepositoryImpl: RecipeRepositoryImpl): RecipeRepository =
        recipeRepositoryImpl

    @Provides
    fun getRecipeRemoteDataSource(retrofit: Retrofit):RemoteDataSource = retrofit.create(RemoteDataSource::class.java)

}