package com.kishor.kotlin.algo.problems.arrayandstrings

fun main() {
    val input = arrayOf<Int>(3, 5, 8, 2, 4, 5, 8)
    val remainingWork = calculateRemainingWork(input)
    println(remainingWork)

}

fun calculateRemainingWork(input: Array<Int>): Int {
    val list = input.toMutableList()
    list.sortDescending()
    var diff = 0
    for (i in 0 until list.size - 2) {
        println(i)
        if (list[i] == list[i+1]) {
            list.removeAt(i)
            list.removeAt(i+1)
        } else {
            diff += list[i] - list[i+1]
        }
    }

    if (diff == list[list.size - 1]) {
        return 0
    }
    else {
        diff += list[list.size - 1]
    }

    return diff
}
