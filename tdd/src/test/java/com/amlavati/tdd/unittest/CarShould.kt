package com.amlavati.tdd.unittest

import com.amlavati.tdd.Car
import com.amlavati.tdd.Engine
import com.amlavati.tdd.util.MainCoroutineRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class CarShould {

    @Before
    fun setUp() {
        runTest {
            whenever(engine.turnOn()).thenReturn(flow {
                emit(25)
                emit(50)
                emit(95)
            })
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var coroutineRule = MainCoroutineRule()

    private val engine: Engine = mock()
    private val car = Car(engine, 5.0)

    @Test
    fun loosingFuelWhenTurnedOn() = runTest {
        car.turnOn()
        assertThat(4.5).isEqualTo(car.fuel)
    }

    @Test
    fun turnOnEngine() = runTest {
        car.turnOn()
//
        verify(engine, times(1)).turnOn()
    }

}