package com.kishor.kotlin.algo.recursion



// Time: O(n*2^n)
// Space: O(n*2^n)

fun powerset(array: List<Int>, idx: Int = array.size - 1): List<List<Int>> {
    if (idx < 0) {
        val emptySet = listOf<Int>()
        return mutableListOf(emptySet)
    }

    val ele = array[idx]
    val subset = powerset(array, idx - 1).toMutableList()
    val length = subset.size

    for (i in 0 until length) {
        val currentSubset = subset[i].toMutableList()
        currentSubset.add(ele)
        subset.add(currentSubset)
    }

    return subset

}

fun powerset(array: List<Int>): List<List<Int>> {
    var subset = mutableListOf<List<Int>>()
    subset.add(emptyList())

    for (ele in array) {
        for (j in 0 until subset.size) {
            val currentSubset = subset[j].toMutableList()
            currentSubset.add(ele)
            subset.add(currentSubset)
        }
    }

    return subset

}