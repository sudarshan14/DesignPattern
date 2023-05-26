package com.amlavati.tdd.acceptancetest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.amlavati.tdd.Car
import com.amlavati.tdd.Engine
import com.amlavati.tdd.util.MainCoroutineRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CarFeature {


    @get:Rule
    var coroutineRule = MainCoroutineRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val engine = Engine()
    private val car = Car(engine, 6.0)

    @Test
    fun carIsLoosingFuelWhenTurnedOn() {
        car.turnOn()
        assertThat(5.5).isEqualTo(car.fuel)
    }


//    @Test
//    fun carIsTurningOnItsEngineAndIncreaseTheTemperature() = runTest {
//
//        car.turnOn()
////        advanceTimeBy(6001)
//        advanceUntilIdle()
//        assertThat(95.0).isEqualTo(car.engine.temperature)
//        assertThat(car.engine.isTurnedOn).isTrue()
//    }

    @Test
    fun carIsTurningOnItsEngineAndIncreaseTheTemperature() = runTest {

        car.turnOn()
        advanceTimeBy(2001)
        assertThat(25.0).isEqualTo(car.engine.temperature)

        advanceTimeBy(2001)
        assertThat(50.0).isEqualTo(car.engine.temperature)

        advanceTimeBy(2001)
        assertThat(95.0).isEqualTo(car.engine.temperature)

        assertThat(car.engine.isTurnedOn).isTrue()
    }
}