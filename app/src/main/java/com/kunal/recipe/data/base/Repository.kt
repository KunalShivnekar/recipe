package com.kunal.recipe.data.base

import androidx.lifecycle.LiveData

/**
 * Created by kunal on 2019-08-22.
 */
interface Repository<T> {

    suspend fun getItems(): LiveData<T>
}