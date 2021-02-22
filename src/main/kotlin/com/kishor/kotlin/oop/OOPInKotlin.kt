package com.kishor.kotlin.oop

fun main() {
//    printAvenger("Tony Stark")
//    printAvenger("Tony Stark", "Iron Man")
//    printAvenger("Tony Stark", "Iron Man", "Chicago")

    val hulk = Hulk()
    val rocket = Rocket()
    callAvenger(hulk)
    callAvenger(rocket)

}

fun callAvenger(avengers: Avengers) {
    avengers.assemble()
    avengers.protect()
}

//
//fun printAvenger(name: String) {
//    println(name)
//}
//
//fun printAvenger(name: String, role: String) {
//    println("$name is $role")
//}
//
//fun printAvenger(name: String, role: String, city: String) {
//    println("$name is $role and $city")
//}

// or function overloading can be achieved by default values to parameter
// Single function severs all
fun printAvenger(name: String, role: String = "", city: String = "") {
    println("$name is $role and $city")
}