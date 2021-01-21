package com.kishor.algo.search

class BinarySearch {

    fun binarySearch(list: MutableList<Int>, value: Int): Int {
        var left = 0
        var right = list.size - 1
        var mid = (left + right)/2
        while (left <= right) {
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