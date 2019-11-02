package com.kunal.recipe.di.modules

import com.google.gson.Gson
import com.kunal.recipe.di.components.DataComponent
import com.kunal.recipe.network.http.HttpClient
import com.kunal.recipe.network.http.HttpClientImpl
import dagger.Module
import dagger.Provides

/**
 * Created by kunal on 2019-08-20.
 */
@Module(subcomponents = [DataComponent::class])
class AppModule {

    @Provides
    fun getHttpApiClient(httpClientImpl: HttpClientImpl): HttpClient = httpClientImpl

    @Provides
    fun getGson(): Gson = Gson()
}