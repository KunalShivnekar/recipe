package com.kunal.recipe.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import io.mockk.*
import org.junit.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
abstract class BaseUnitTest {

    protected lateinit var lifecycleOwner: LifecycleOwner

    @Before
    open fun setup() {
        lifecycleOwner = mockk<LifecycleOwner>()
        val lifecycle = mockk<Lifecycle>(relaxed = true)
        every { lifecycleOwner.lifecycle } returns lifecycle
    }

}
