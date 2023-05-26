package com.amlavati.tdd.unittest

import com.amlavati.tdd.Engine
import com.amlavati.tdd.util.MainCoroutineRule
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class EngineShould {
    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    var coroutineRule = MainCoroutineRule()
    private val engine = Engine()

    @Test
    fun turnOn() = runTest {
        engine.turnOn()
        assertThat(engine.isTurnedOn).isTrue()
    }

//    @Test
//    fun riseTemperatureWhenItsTurnedOn()= runTest {
//      val value =   engine.turnOn()
//      //  assertThat(90).isEqualTo(engine.temperature)
//        assertEquals(95, engine.temperature)
//    }

    @Test
    fun riseTemperatureWhenItsTurnedOn() = runTest {
        val flow = engine.turnOn()
        val actual = flow.toList()
        //  assertThat(90).isEqualTo(engine.temperature)
        assertThat(listOf(25, 50, 95)).isEqualTo(actual)
    }
}