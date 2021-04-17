package com.kishor.kotlin.algo.problems.arrayandstrings

fun main(args : Array<String>) {
    // Call areTheyEqual() with test cases here
    println(areTheyEqual(arrayOf(1, 2, 3, 4), arrayOf(1, 4, 3, 2)))
}

fun areTheyEqual(arr_a: Array<Int>, arr_b: Array<Int>): Boolean {

    val mapOf = mutableMapOf<Int, Int>()

    for (i in arr_a) {
        mapOf.put(i, mapOf.getOrDefault(i, 0) + 1)
    }

    for (j in arr_b) {
        if (!mapOf.containsKey(j)) return false
        else mapOf.remove(j)
    }

    return mapOf.isEmpty()
}