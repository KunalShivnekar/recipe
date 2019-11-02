package com.kunal.recipe.view.base

import androidx.lifecycle.ViewModel

/**
 * Created by kunal on 2019-08-20.
 */
abstract class BaseViewModelImpl : BaseViewModel, ViewModel() {


    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    override fun onCreate() {
        //Base Implementation
    }

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    override fun onPause() {
        //Base Implementation
    }

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    override fun onResume() {
        //Base Implementation
    }

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    override fun onStart() {
        //Base Implementation
    }

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    override fun onStop() {
        //Base Implementation
    }

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    override fun onDestroy() {
        //Base Implementation
    }
}