package com.kishor.kotlin.oop

abstract class Avengers(val numbers: Int, val superPower: String) {

    abstract fun assemble()
    abstract fun protect()

    fun attack() {
        // some functionality
    }

}

abstract class GalaxyWarriors(private val superPowers: String = "Galaxy") :
    Avengers(superPower = superPowers, numbers = 4) {

    abstract fun driveFast()

    override fun assemble() {
        println("on planet somewhere")
    }

    override fun protect() {
        println("Protect command")
    }
}

class Rocket : GalaxyWarriors() {
    override fun driveFast() {
        println("Drive the space ship")
    }

//    override fun protect() {
//        println("Rocket command")
//    }
}

class Hulk : Avengers(1, "Hulk smash") {
    override fun assemble() {
        println("Earth")
    }

    override fun protect() {
        println("Always angry")
    }
}