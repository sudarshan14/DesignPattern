package com.amlavati.designpatterns

import org.assertj.core.api.Assertions
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val printer = HelloWorld()

        val thread = Thread(printer)
        thread.start()
     //   printer.run()
    }
}