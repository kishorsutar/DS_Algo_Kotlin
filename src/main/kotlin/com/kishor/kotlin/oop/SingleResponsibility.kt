package com.kishor.kotlin.oop

//class Avenger(val name: String, val power: String) {
//
//    fun responsibility() {
//        println("Hi, I'm $name and my power is $power")
//    }
//}


/// changes to

data class Avenger(val name: String, val power: String)

class Responsibility() {

    fun responsibility(avenger: Avenger) {
        val name = avenger.name
        val power = avenger.power
        println("Hi, I'm $name and my power is $power")
    }
}