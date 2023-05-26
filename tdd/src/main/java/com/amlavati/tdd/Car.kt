package com.amlavati.tdd

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class Car(
    var engine: Engine,
    var fuel: Double
) {

    fun turnOn() {
        fuel -= .5
        CoroutineScope(Dispatchers.Main).launch {
            engine.turnOn().collectLatest {
                Log.d("TDD", "temp of engine $it")
            }
        }

    }

}