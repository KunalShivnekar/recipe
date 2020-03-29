package com.kunal.recipe.data.base

/**
 * Created by kunal on 2019-08-20.
 */
interface DataSource<T> {

    interface GetItemsCallback<T> {

        fun onFailure(response: Response<T>)

        fun onSuccess(data: List<T>)
    }

    fun getItems(getItemsCallback: GetItemsCallback<T>)
}