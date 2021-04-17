package com.kishor.kotlin.algo.problems.arrayandstrings

fun main(args: Array<String>) {
    println(numberOfWays(arrayOf(1, 2, 3, 4, 3), 6))
    println(numberOfWays(arrayOf(1, 5, 3, 3, 3), 6))
    println(numberOfWaysUsingHashSet(arrayOf(1, 2, 3, 4, 3), 6))
    println(numberOfWaysUsingHashSet(arrayOf(1, 5, 3, 3, 3), 6))
}

fun numberOfWays(arr: Array<Int>, k: Int): Int {

    arr.sort()
    var count = 0
    for (ele in arr) {
        if (isPresentIn(k - ele, arr)) count++
    }

    return count
}

fun isPresentIn(diff: Int, arr: Array<Int>): Boolean {

    var left = 0
    var right = arr.size - 1

    while (left < right) {
        val mid = (left + right) / 2

        if (arr[mid] == diff) return true
        else if (diff < mid) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    return false
}

fun numberOfWaysUsingHashSet(arr: Array<Int>, k: Int): Int {
    val dataSet = mutableMapOf<Int, Int>()

    for (ele in arr) {
        dataSet[ele] = dataSet.getOrDefault(ele, 0) + 1

    }

    var count = 0

    for (ele in arr) {
        if (dataSet.contains(ele)) {
            count += dataSet[ele]!!
        }
    }

    return (count / 2) - 1
}