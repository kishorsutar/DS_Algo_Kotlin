package com.kishor.kotlin.algo.dp

import java.util.ArrayList




fun main() {
    val markings = listOf(listOf(0, 3),listOf(0,5),listOf(0,7),listOf(1,6),listOf(1,8),listOf(1,9),listOf(2,3),listOf(2,5),listOf(2,6))
    println(chooseAFlask(markings, 3, listOf(4,6,6,7)))
}

fun chooseAFlask(markings: List<List<Int>>, flaskTypes: Int, requirements: List<Int>): Int {
    val flaskMap = mutableMapOf<Int, MutableList<Int>>()
    for (mark in markings) {
        if (mark[0] in flaskMap) {
            flaskMap[mark[0]]!!.add(mark[1])
        } else {
            flaskMap[mark[0]] = mutableListOf(mark[1])
        }
    }

    var minSum =Int.MAX_VALUE
    var flaskId = -1

        for (flsk in 0 until flaskTypes) {
            for (req in requirements) {
                var currentSum = 0
                val flaskMarkings = flaskMap[flsk]!!
                for (mark in flaskMarkings) {
                    if (mark >= req) {
                        currentSum += mark - req
                    }
                }

                if (currentSum < minSum) {
                    minSum = currentSum
                    flaskId = flsk
                }
            }
        }

    return flaskId

}


fun chooseAFlask(numOrders: Int, requirements: IntArray, flaskTypes: Int, markings: List<List<Int>>): Int {
    val map =
        arrayOf(mutableListOf(flaskTypes)) //building a map for each flask type for fast retrieval
    for (mark in markings) {
        map[mark[0]].add(mark[1])
    }
    var min_cost = 1e11.toLong()
    var cost: Long
    var index = -1
    for (i in 0 until flaskTypes) {
        cost = 0
        for (j in requirements.indices) {
            cost += upperBound(map[i], requirements[j]) - requirements[j]
        }
        if (cost < min_cost) {
            min_cost = cost
            index = i
        }
    }
    return index
}

fun isContainsDuplicate(string: String): Boolean {
    var asciiArray = IntArray(26) { 0 }

    for (ch in string) {
        val value = 96 - ch.toInt()
        asciiArray[value]++
    }

    for (i in 0 until asciiArray.size) {
        if (asciiArray[i] > 1) return false
    }

    return true
}

private fun upperBound(arr: List<Int>?, x: Int): Long {
    var l = 0
    var r = arr!!.size - 1
    var mid: Int
    if (arr[0] >= x) return arr[0].toLong()
    if (arr[r] < x) return Long.MAX_VALUE
    while (l < r) {
        mid = (l + r) / 2
        if (arr[mid] >= x && arr[mid] <= x) return arr[mid].toLong()
        if (arr[mid] > x) r = mid - 1 else l = mid + 1
    }
    return Long.MAX_VALUE
}