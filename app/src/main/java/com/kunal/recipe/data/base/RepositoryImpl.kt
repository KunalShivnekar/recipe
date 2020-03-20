package com.kunal.recipe.data.base

import androidx.lifecycle.LiveData

/**
 * Created by kunal on 2019-08-22.
 */
abstract class BaseRepositoryImpl<T> : Repository<T> {

    override suspend fun getItems(forceUpdate: Boolean): Response<List<T>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getItem(itemId: String): Response<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun updateItem(item: T) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteItem(itemId: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun deleteItems() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}