package com.kunal.recipe.data.recipe

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.kunal.recipe.data.base.DataSource.GetItemsCallback
import com.kunal.recipe.data.base.DataSourceImpl
import com.kunal.recipe.data.base.Response
import com.kunal.recipe.model.Recipe
import com.kunal.recipe.network.http.HttpClient
import com.kunal.recipe.network.http.HttpClient.ResponseCallback
import com.kunal.recipe.network.http.HttpRequest
import com.kunal.recipe.network.http.HttpResponse
import java.io.IOException
import javax.inject.Inject

/**
 * Created by kunal on 2019-08-22.
 */
class RemoteDataSourceImpl @Inject constructor(
    private val httpClient: HttpClient,
    private val gson: Gson
) : RemoteDataSource, DataSourceImpl<Recipe>() {

    private val endPointURL: String =
        "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/baking.json"

    override fun getItems(getItemsCallback: GetItemsCallback<Recipe>) {
        val httpRequest = HttpRequest(endPointURL)
        httpClient.get(httpRequest, object : ResponseCallback {
            override fun onSuccess(httpResponse: HttpResponse) {
                val listType = object : TypeToken<List<Recipe>>() {}.type
                getItemsCallback.onSuccess(gson.fromJson<List<Recipe>>(httpResponse.body, listType))
            }

            override fun onFailure(httpResponse: HttpResponse) {
                getItemsCallback.onFailure(
                    if (httpResponse.exception is IOException) {
                        Response("Network Error")
                    } else {
                        Response("Server Error")
                    }
                )
            }
        })
    }
}