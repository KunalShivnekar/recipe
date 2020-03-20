package com.kunal.recipe.data.base

/**
 * Created by kunal on 2019-08-20.
 */

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Response<out R> {

    data class Success<out T>(val data: T) : Response<T>()
    data class Error(val exception: Exception, val description:String) : Response<Nothing>()
    object Loading : Response<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception description=$description]"
            Loading -> "Loading"
        }
    }
}