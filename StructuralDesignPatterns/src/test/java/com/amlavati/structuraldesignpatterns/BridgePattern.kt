package com.amlavati.structuraldesignpatterns

import org.assertj.core.api.Assertions
import org.junit.Test

/**
 * Split characteristic into different inheritance tree
 * Decouples abstraction from implementation so that the two can vary independently
 * This pattern is used to separate an abstraction from its implementation so that both can be modified independently
 * This pattern involves an interface which acts as a bridge between abstraction class and implementer class
 * */

interface Device {
    var volume: Int
    fun getName(): String
}

class Radio : Device {

    override var volume = 0

    override fun getName() = "Radio $this"

}

class TV : Device {
    override var volume = 0
    override fun getName() = "TV $this"
}


interface Remote {

    fun volumeUp()
    fun volumeDown()
}

class BasicRemote(private val device: Device) : Remote {
    override fun volumeUp() {
        device.volume++
        println("${device.getName()} volume up ${device.volume}")
    }

    override fun volumeDown() {
        device.volume--
        println("${device.getName()} volume down ${device.volume}")
    }
}

class BridgeTest {

    @Test
    fun testBridge() {
        val tv = TV()
        val radio = Radio()

        val tvRemote = BasicRemote(tv)
        val radioRemote = BasicRemote(radio)

        tvRemote.volumeUp()
        tvRemote.volumeUp()
        tvRemote.volumeDown()

        radioRemote.volumeUp()
        radioRemote.volumeUp()
        radioRemote.volumeDown()

        Assertions.assertThat(tv.volume).isEqualTo(1)
        Assertions.assertThat(radio.volume).isEqualTo(1)

    }
}