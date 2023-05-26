package com.amlavati.designpatterns

class HelloWorld : Runnable {
    override fun run() {
        print("Hello World ${Thread.currentThread().id}")
    }

}