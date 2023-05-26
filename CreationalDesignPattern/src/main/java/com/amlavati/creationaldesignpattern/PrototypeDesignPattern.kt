package com.amlavati.creationaldesignpattern

import org.junit.Test

// allows copy of existing objects
// without depending on their classes
// only reliant on interface
// the object it self provides the copy function,


abstract class Shape : Cloneable {
    var id: String? = null
    var shape: String? = null

    abstract fun draw()

    public override fun clone(): Any {
        var clone: Any? = null

        runCatching {
            clone = super.clone()
        }.onSuccess {

        }.onFailure {
            it.printStackTrace()
        }

        return clone!!
    }
}

class Rectangle : Shape() {
    override fun draw() {
        println("Rectangle on draw")
    }

    init {
        shape = "Rectabgle"
    }
}

class Circle : Shape() {
    override fun draw() {
        println("Circle on draw")
    }

    init {
        shape = "Circle"
    }
}

class Square : Shape() {
    override fun draw() {
        println("Square on draw")
    }

    init {
        shape = "Square"
    }
}

object ShapeCache {
    private val shapeMap = hashMapOf<String, Shape?>()
    private val shapeMaps = mutableMapOf<String, Shape?>()

    fun loadCache() {
        val circle = Circle()
        val square = Square()
        val rectangle = Rectangle()

        shapeMap["1"] = circle
        shapeMap["2"] = square
        shapeMap["3"] = rectangle
    }

    fun getShape(id: String): Shape {

        val cachedShape = shapeMap[id]
        return cachedShape?.clone() as Shape
    }
}

class PrototypeTest() {

    @Test
    fun test() {
        ShapeCache.loadCache()
        val clonedShape1 = ShapeCache.getShape("1")
        val clonedShape2 = ShapeCache.getShape("2")
        val clonedShape3 = ShapeCache.getShape("3")

        clonedShape1.draw()
        clonedShape2.draw()
        clonedShape3.draw()
    }
}