package com.kishor.kotlin.algo.problems.arrayandstrings

import kotlin.math.min

fun main() {
    println(getMinSizeWithSumEqualToGreaterThan(7, arrayListOf(2, 4, 2, 5, 1)))
}

fun getMinSizeWithSumEqualToGreaterThan(k: Int, array: List<Int>): Int {
    var minSize = Int.MAX_VALUE

    var start = 0
    var currSum = 0

    for (end in 0 until array.size) {
        currSum += array[end]

        while (currSum >= k) {
            minSize = min(minSize, end - start + 1)
            currSum -= array[start]
            start++
        }

    }

    return minSize

}