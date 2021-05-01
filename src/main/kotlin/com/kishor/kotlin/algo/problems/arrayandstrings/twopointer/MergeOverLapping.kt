package com.kishor.kotlin.algo.problems.arrayandstrings.twopointer

fun main() {
    val input = listOf(
        listOf(43, 49),
        listOf(9, 12),
        listOf(12, 54),
        listOf(45, 90),
        listOf(91, 93)
    )

println(mergeOverlappingIntervals(input))
}

fun mergeOverlappingIntervals(intervals: List<List<Int>>): List<List<Int>> {
    if (intervals.size == 0) return emptyList<List<Int>>()

    if (intervals.size == 1) return intervals

    val overLappedList = mutableListOf<MutableList<Int>>()

    overLappedList.add(intervals[0]  as MutableList<Int>)

    for (i in 1 until intervals.size) {
        val start = intervals[i][0]
        val last = overLappedList[overLappedList.size - 1][1]
        if (start <= last) {
            overLappedList[overLappedList.size - 1][1] = intervals[i][1]
        } else {
            overLappedList.add(intervals[i] as MutableList<Int>)
        }
    }

    return overLappedList
}