package com.kishor.kotlin.oop

//abstract class Robot {
//    abstract fun goToLocation(lat: Double, long: Double)
//    abstract fun jump()
//}
//
//class HeavyRobot : Robot(){
//    override fun goToLocation(lat: Double, long: Double) {
//    }
//
//    override fun jump() {
//        //
//        TODO("this is unnecessary for this robot")
//    }
//}

// changes to


abstract class Robot {
    abstract fun goToLocation(lat: Double, long: Double)
}

abstract class LightRobot : Robot() {
    abstract fun jump()
}

class HeavyRobot : Robot() {
    override fun goToLocation(lat: Double, long: Double) {
        // this is useful
    }
}

