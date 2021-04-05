package com.kishor.kotlin.algo.sorting

fun main() {
    println(quickselect(mutableListOf(7, 2, 5, 1, 9, 3), 3))
}

fun quickselect(array: MutableList<Int>, k: Int): Int {

    // solve using quick sort method
    // do the partition logic until partition/pivot + 1 == k
    // return partition
    var pivot = 0
    return quickSelectHelper(array, 0, array.size - 1, k, pivot)
}

fun quickSelectHelper(array: MutableList<Int>, left: Int, right: Int, k: Int, pivot: Int): Int {

    if (right > left) {
        val tempPivot = partition(array, left, right)

        if (tempPivot + 1 == k) return tempPivot
        else {
            quickSelectHelper(array, left, pivot - 1, k, tempPivot)
            quickSelectHelper(array, pivot + 1, right, k, tempPivot)
            return pivot
        }
    } else {
        return -1
    }

}

fun partition(array: MutableList<Int>, left: Int, right: Int): Int {
    var low = left
    var high = right
    val pivotItem = array[left]

    while (low < high) {

        while (array[low] <= pivotItem) {
            low++
        }

        while (array[high] > pivotItem) {
            high--
        }

        val temp = array[low]
        array[low] = array[high]
        array[high] = temp
    }

    array[low] = array[high]
    array[high] = pivotItem

    return high
}
