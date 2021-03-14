package com.kishor.kotlin.oop

//interface IRobot {
//    fun gotToLocation()
//    fun wave()
//}
//
//class StationaryRobot: IRobot {
//    override fun gotToLocation() {
//        TODO("Not yet implemented")
//    }
//
//    override fun wave() {
//        // no use
//        TODO("Not yet implemented")
//    }
//}

interface WavingRobot {
    fun wave()
}

interface MobileRobot {
    fun goToLocation()
}