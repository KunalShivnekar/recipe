package com.kunal.recipe.data.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kunal.recipe.data.base.RepositoryImpl
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
    RecipeRepository, RepositoryImpl<List<Recipe>>() {

    override val error: MutableLiveData<Response> = MutableLiveData()

    override suspend fun getItems(): LiveData<List<Recipe>> {
        val liveData = MutableLiveData<List<Recipe>>()
        try {
            liveData.value = remoteDataSource.getItems()
        } catch (e:Throwable){
            error.value = Response(e.localizedMessage)
        }
        return liveData
    }
}