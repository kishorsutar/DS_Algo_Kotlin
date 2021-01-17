package com.kishor.algo.sorting

fun main() {
    val sortedString: String = InsertionSort().insertionSort("insertionsort")
    println("InsertionSort $sortedString")
}

class InsertionSort {

    fun insertionSort(inputString: String): String {
        val charArray = inputString.toCharArray()
        for (i in 0 until charArray.size) {
            var j = i
            while (j > 0 && charArray[j] < charArray[j - 1]) {
                swap(j, j - 1, charArray)
                j--
            }
        }

        return String(charArray)
    }

    private fun swap(j: Int, i: Int, charArray: CharArray) {
        val tempChar = charArray[i]
        charArray[i] = charArray[j]
        charArray[j] = tempChar
    }
}