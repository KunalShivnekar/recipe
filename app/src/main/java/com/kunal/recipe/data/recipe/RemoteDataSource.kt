package com.kunal.recipe.data.recipe

import com.kunal.recipe.data.base.DataSource
import com.kunal.recipe.model.Recipe
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by kunal on 2019-08-22.
 */
interface RemoteDataSource {
    @GET("topher/2017/May/59121517_baking/baking.json")
    fun getItems(): Call<List<Recipe>>
}