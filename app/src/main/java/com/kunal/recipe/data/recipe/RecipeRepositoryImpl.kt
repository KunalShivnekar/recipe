package com.kunal.recipe.data.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kunal.recipe.data.base.RepositoryImpl
import com.kunal.recipe.data.base.Response
import com.kunal.recipe.model.Recipe
import retrofit2.Call
import retrofit2.Callback
import javax.inject.Inject

/**
 * Created by kunal on 2019-08-22.
 */
class RecipeRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    RecipeRepository, RepositoryImpl<List<Recipe>>() {

    override val error: MutableLiveData<Response> = MutableLiveData()

    override fun getItems(): LiveData<List<Recipe>> {
        val liveData = MutableLiveData<List<Recipe>>()
        remoteDataSource.getItems().enqueue(object : Callback<List<Recipe>> {
            override fun onFailure(call: Call<List<Recipe>>, t: Throwable) {
                error.value = Response(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<List<Recipe>>,
                response: retrofit2.Response<List<Recipe>>
            ) {
                liveData.value = response.body()
            }
        })
        return liveData
    }
}