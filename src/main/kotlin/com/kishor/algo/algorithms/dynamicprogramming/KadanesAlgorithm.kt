package com.kishor.algo.algorithms.dynamicprogramming

import kotlin.math.max

fun main() {
    println(" ${KadanesAlgorithm().findMaxSubarraySum(listOf(3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4))}")
}

class KadanesAlgorithm {

    fun findMaxSubarraySum(array: List<Int>): Int {
        var maxSoFar = array[0]
        var maxSum = array[0]

        for (i in 1 until array.size) {
            val num = array[i]
            maxSoFar = max(num, maxSoFar + num)
            maxSum = max(maxSoFar, maxSum)
        }

        return maxSum
    }
}
