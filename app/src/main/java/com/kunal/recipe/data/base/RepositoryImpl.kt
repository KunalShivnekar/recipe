package com.kunal.recipe.data.base

import androidx.lifecycle.LiveData

/**
 * Created by kunal on 2019-08-22.
 */
abstract class RepositoryImpl<T> : Repository<T> {

    override fun getItems(): LiveData<T> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}