package com.kunal.recipe.network.http

/**
 * Created by kunal on 2019-08-20.
 */
data class HttpRequest(val endpointUrl: String) {

    var headers: Map<String, String> = HashMap()

    constructor(endpointUrl: String, headers: Map<String, String>) : this(endpointUrl) {
        this.headers = headers
    }
}