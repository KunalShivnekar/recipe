package com.kunal.recipe.data.base

import com.kunal.recipe.data.base.DataSource.GetItemsCallback

/**
 * Created by kunal on 2019-08-20.
 */
abstract class DataSourceImpl<T> : DataSource<T> {

    override fun getItems(getItemsCallback: GetItemsCallback<T>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}