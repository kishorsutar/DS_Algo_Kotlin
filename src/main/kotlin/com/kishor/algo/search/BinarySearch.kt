package com.kishor.algo.search

fun main() {
//    val list = listOf<Int>(2, 4, 5, 6, 9, 12)
    val list = arrayOf(2, 4, 5, 6, 9, 12)
    println("Binary Search ${BinarySearch().binarySearch(list, 12)}")
    println("Binary recursive Search ${BinarySearch().binaryRecursive(list, 12)}")
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

    fun binarySearch(list: Array<Int>,  item: Int): Int {
        var left = 0
        var right = list.size - 1

        while (left <= right) { // <= is imp since middle element might miss
            var mid = (left + right)/2

            if (list[mid] == item) {
                return mid
            }
            if (item < list[mid]) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return -1
    }

    fun binaryRecursive(list: Array<Int>,  item: Int): Int {
        return binaryHelper(list, item, 0, list.size - 1)
    }

    private fun binaryHelper(list: Array<Int>, item: Int, left: Int, right: Int): Int{
        if (right < left)  return  -1
        val mid = (left + right)/2
        if (list[mid] == item) return mid

        if (item < list[mid]) {
            return binaryHelper(list, item, left, mid - 1)
        } else {
            return binaryHelper(list, item, mid + 1, right)
        }
    }



}