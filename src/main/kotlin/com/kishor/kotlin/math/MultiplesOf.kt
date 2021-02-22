package com.kishor.kotlin.math

fun main() {
    getMultipleOf(1000, 3, 5)
}

fun getMultipleOf(value: Int, first: Int, second: Int) {
    var sum = 0
    for (i in first until value) {
        if ((i % 3 == 0) || (i % 5) == 0) {
            sum += i
        }
    }

    println(sum)
}
