package com.amlavati.structuraldesignpatterns

// first abstraction
abstract class EntertainmentDevice {
    var deviceState: Int = 0
    var maxSettings: Int = 0
    var volumeLevel: Int = 0

    abstract fun buttonFivePressed()
    abstract fun buttonSixPressed()

    fun buttonSevenPressed() {
        volumeLevel++
        println("Volume at : $volumeLevel")
    }

    fun buttonEightPressed() {
        volumeLevel--
        println("Volume at : $volumeLevel")
    }

    fun deviceFeedback() {
        if (deviceState > maxSettings || deviceState < 0) {
            deviceState = 0
            println("Device state on $deviceState")
        }
    }

}


class TVDevice(numDeviceState: Int, newMaxSettings: Int) :
    EntertainmentDevice() {

    init {
        deviceState = numDeviceState
        maxSettings = newMaxSettings
    }

    override fun buttonFivePressed() {
        deviceState--
        println("Channel down")
    }

    override fun buttonSixPressed() {
        deviceState++
        println("Channel up")
    }

}

class DVDPlayerDevice(numDeviceState: Int, newMaxSettings: Int) :
    EntertainmentDevice() {

    init {
        deviceState = numDeviceState
        maxSettings = newMaxSettings
    }

    override fun buttonFivePressed() {
        deviceState--
        println("DVD skip to chapter $deviceState")
    }

    override fun buttonSixPressed() {
        deviceState++
        println("DVD next to chapter $deviceState")
    }

}

//second abstraction
abstract class RemoteButton(private val entertainmentDevice: EntertainmentDevice) {

    fun buttonSevenPressed() {
        entertainmentDevice.buttonSevenPressed()
    }


    fun buttonEightPressed() {
        entertainmentDevice.buttonEightPressed()
    }

    fun buttonFivePressed() {
        entertainmentDevice.buttonFivePressed()
    }

    fun buttonSixPressed() {
        entertainmentDevice.buttonSixPressed()
    }

    fun deviceFeedback() {
        entertainmentDevice.deviceFeedback()
    }

    abstract fun buttonNinePressed()

}


class TVRemoteMute(private val entertainmentDevice: EntertainmentDevice) :
    RemoteButton(entertainmentDevice) {

    override fun buttonNinePressed() {
        println("tv was muted")
    }
}

class DVDRemote(private val entertainmentDevice: EntertainmentDevice) :
    RemoteButton(entertainmentDevice) {

    var play = true
    override fun buttonNinePressed() {
        play = !play
        println("DVD is playing $play")
    }
}

class Test {

    @org.junit.Test
    fun testBridge() {
        val remoteTv = TVRemoteMute(TVDevice(1, 100))

        remoteTv.buttonFivePressed()
        remoteTv.buttonSixPressed()
        remoteTv.buttonNinePressed()
        remoteTv.buttonSevenPressed()
        remoteTv.deviceFeedback()


        val dvdRemote = DVDRemote(DVDPlayerDevice(1, 24))
        dvdRemote.buttonFivePressed()
        dvdRemote.buttonSixPressed()
        dvdRemote.buttonNinePressed()
        dvdRemote.buttonNinePressed()
        dvdRemote.buttonSevenPressed()
        dvdRemote.deviceFeedback()
    }
}