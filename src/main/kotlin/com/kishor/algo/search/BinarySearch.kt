package com.kishor.algo.search

fun main() {
    val list = listOf<Int>(2, 4, 5, 6, 9, 12)
    println("Binary Search ${BinarySearch().binarySearch(list, 1)}")
}

class BinarySearch {

    fun binarySearch(list: List<Int>, value: Int): Int {
        var left = 0
        var right = list.size - 1
        var mid = 0
        while (left <= right) {
            mid = (left + right)/2
            if (list[mid] == value) {
                return mid
            } else if (value < list[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return -1
    }
}