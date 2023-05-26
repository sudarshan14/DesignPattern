package com.amlavati.tictactoe

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
        val obj = Child()
        obj.add(1, 2)

        val obj2 = Parent()
        obj2.add(2, 3)
        obj.substract()


    }
}

open class Parent {
    open fun add(number: Int, number2: Int) {
        print(number + number2)
    }
}

class Child : Parent(), A {
    override fun add(number: Int, number2: Int) {
        print(" output is ${number * number + number2 * number2}")
    }
    override fun substract() {
        println("substract from child ")
    }
}

class Child3 : Parent(), A {
    override fun add(number: Int, number2: Int) {
        print(" output is ${number * number + number2 * number2}")
    }
    override fun substract() {
        println("substract from child 3")
    }
}

interface A {
    fun substract()
}
