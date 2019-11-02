package com.kunal.recipe.view.base

import androidx.lifecycle.LifecycleObserver

/**
 * Created by kunal on 2019-08-20.
 */
interface BaseView {

    /**
     * Use this method to add a lifecycle observer to this view
     *
     * @param observer the observer to be attached
     */
    fun attachObserver(observer: LifecycleObserver)

    /**
     * Use this method to hide progress bar on the view
     */
    fun hideLoader()

    /**
     * This method shows error message on the view.
     *
     * @param  error string to show
     */
    fun showError(error: String)

    /**
     * Use this method to show progress bar on the view
     */
    fun showLoader()
}