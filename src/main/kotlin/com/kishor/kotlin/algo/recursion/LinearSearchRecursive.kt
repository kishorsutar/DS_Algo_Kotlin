package com.kishor.kotlin.algo.recursion

fun main() {
    val linearSearchRecursive = LinearSearchRecursive()
    val array = arrayOf(2, 3, 5, 6, 90, 102)
    println( "Search index ${linearSearchRecursive.linearSearch(array = array, index = 0, value = 6 )}")
}

class LinearSearchRecursive {

    fun linearSearch(array: Array<Int>, index: Int, value: Int): Int {
        if (index >= array.size) return -1
        if (array[index] == value) {
            return index
        }
        else {
            return linearSearch(array, index+1, value)
        }
    }

}