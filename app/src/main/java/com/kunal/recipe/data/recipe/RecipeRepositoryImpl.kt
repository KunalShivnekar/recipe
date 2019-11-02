package com.kunal.recipe.data.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kunal.recipe.data.base.DataSource
import com.kunal.recipe.data.base.DataSource.GetItemsCallback
import com.kunal.recipe.data.base.RepositoryImpl
import com.kunal.recipe.data.base.Response
import com.kunal.recipe.model.Recipe
import javax.inject.Inject

/**
 * Created by kunal on 2019-08-22.
 */
class RecipeRepositoryImpl @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    RecipeRepository, RepositoryImpl<List<Recipe>>() {

    override val error: MutableLiveData<Response> = MutableLiveData()

    override fun getItems(): LiveData<List<Recipe>> {
        val liveData = MutableLiveData<List<Recipe>>()
        remoteDataSource.getItems(object : GetItemsCallback<Recipe> {
            override fun onFailure(response: Response) {
                error.value = response
            }

            override fun onSuccess(data: List<Recipe>) {
                liveData.value = data
            }
        })
        return liveData
    }
}