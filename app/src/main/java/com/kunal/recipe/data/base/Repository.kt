package com.kunal.recipe.data.base

import androidx.lifecycle.LiveData

/**
 * Created by kunal on 2019-08-22.
 */
interface Repository<T> {

    suspend fun getItems(forceUpdate: Boolean = false): Response<List<T>>

    suspend fun getItem(itemId:String): Response<T>

    suspend fun updateItem(item:T)

    suspend fun deleteItem(itemId:String)

    suspend fun deleteItems()
}