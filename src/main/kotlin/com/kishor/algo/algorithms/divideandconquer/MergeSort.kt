package com.kishor.algo.algorithms.divideandconquer

val inputArray = arrayOf(9, 1, -4, 5, 8, -2, 10)
val sorted = Array<Int>(inputArray.size) { 0 }

fun main() {
    MergeSort().mergeSort(0, inputArray.size - 1)
    inputArray.forEach {
        println("$it")
    }
}

class MergeSort {

    fun mergeSort(low: Int, high: Int) {
        if (low >= high) return

        val mid = (low + high) / 2

        mergeSort(low, mid)
        mergeSort(mid + 1, high)

        merge(low, mid, high)
    }

    fun merge(low: Int, middle: Int, high: Int): Array<Int> {

//        inputArray.copyInto(sorted)
        for (i in 0 until inputArray.size) {
            sorted[i] = inputArray[i]
        }

        var i = low
        var j = middle + 1
        var k = low

        while (i <= middle && j <= high) {
            if (sorted[i] <= sorted[j]) {
                inputArray[k++] = sorted[i++]
            } else {
                inputArray[k++] = sorted[j++]
            }
        }
        while (i <= middle) {
            inputArray[k++] = sorted[i++]
        }

        while (j <= high) {
            inputArray[k++] = sorted[j++]
        }
        return inputArray
    }
}
