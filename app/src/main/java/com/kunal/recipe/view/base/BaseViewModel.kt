package com.kunal.recipe.view.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Lifecycle.Event
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 * Created by kunal on 2019-08-20.
 */
interface BaseViewModel : LifecycleObserver {

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    @OnLifecycleEvent(Event.ON_CREATE)
    fun onCreate()

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause()

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume()

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart()

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop()

    /**
     * Lifecycle event listener for the view's Lifecycle
     */
    @OnLifecycleEvent(Event.ON_DESTROY)
    fun onDestroy()
}