package com.kishor.kotlin.algo.recursion

fun main() {
    val output = productSum(listOf(5, 2, listOf(7, -1), 3, listOf(6, listOf(-13, 8), 4)))
    println(output)
}

fun productSum(array: List<*>): Int {

    return helper(array, 1)
}

fun helper(array: List<*>, depth: Int): Int {
    println("helper stack")
    var sum = 0
    for (ele in array) {
        if (ele is List<*>) {
            println(" $sum and $depth")
            sum += helper(ele, depth + 1)
        } else {
            sum += ele as Int
        }
    }

    return depth * sum
}

