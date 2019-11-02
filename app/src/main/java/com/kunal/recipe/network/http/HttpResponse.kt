package com.kunal.recipe.network.http

/**
 * Created by kunal on 2019-08-20.
 */
data class HttpResponse(val code: Int, val body: String) {

    var exception: Exception? = null

    constructor(exception: Exception) : this(0, "") {
        this.exception = exception
    }
}