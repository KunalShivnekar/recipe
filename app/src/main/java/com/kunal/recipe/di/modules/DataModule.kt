package com.kunal.recipe.di.modules

import com.google.gson.Gson
import com.kunal.recipe.data.recipe.RecipeRepository
import com.kunal.recipe.data.recipe.RecipeRepositoryImpl
import com.kunal.recipe.data.recipe.RemoteDataSource
import com.kunal.recipe.network.http.HttpClient
import com.kunal.recipe.network.http.HttpClientImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by kunal on 2019-08-20.
 */
@Module
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


    @Provides
    fun getHttpApiClient(httpClientImpl: HttpClientImpl): HttpClient = httpClientImpl

    @Provides
    fun getGson(): Gson = Gson()

}