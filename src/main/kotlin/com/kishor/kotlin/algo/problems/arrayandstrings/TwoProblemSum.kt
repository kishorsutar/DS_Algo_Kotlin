package com.kishor.kotlin.algo.problems.arrayandstrings

fun twoNumberSumWithHashSet(array: MutableList<Int>, targetSum: Int): List<Int> {

    val set : Set<Int> = array.toSet()

    for (i in 0 until array.size - 1) {
        val diff = targetSum - array[i]
        if (diff != array[i] && set.contains(diff)) {
            return listOf<Int>(diff, array[i])
        }

    }

    return listOf()
}

fun twoNumberSumWithSort(array: MutableList<Int>, targetSum: Int): List<Int> {

    var left = 0
    var right = array.size - 1

    while (left < right) {
        val currentSum = array[left] + array[right]
        when {
            currentSum == targetSum -> {
                return listOf(array[left], array[right])
            }
            currentSum < targetSum -> {
                left++
            }
            currentSum > targetSum -> {
                right--
            }
        }
    }


    return emptyList()
}