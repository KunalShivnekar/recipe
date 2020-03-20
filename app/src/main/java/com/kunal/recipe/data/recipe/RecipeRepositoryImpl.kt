package com.kunal.recipe.data.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kunal.recipe.data.base.BaseRepositoryImpl
import com.kunal.recipe.data.base.Response
import com.kunal.recipe.model.Recipe
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Inject

/**
 * Created by kunal on 2019-08-22.
 */
class RecipeRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    RecipeRepository, BaseRepositoryImpl<Recipe>() {

    override suspend fun getItems(forceUpdate: Boolean): Response<List<Recipe>> {
        return try {
            Response.Success(remoteDataSource.getItems())
        } catch (e:Exception){
            Response.Error(e, "Error while fetching items.")
        }
    }
}