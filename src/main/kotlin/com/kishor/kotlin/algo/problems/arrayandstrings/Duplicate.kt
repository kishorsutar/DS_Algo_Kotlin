package com.kishor.kotlin.algo.problems.arrayandstrings

fun main() {
    println(numKLenSubstrNoRepeats("kishork", 2))
}

fun numKLenSubstrNoRepeats(S: String, K: Int): Int {
    val n = S.length
    if (n < K) return 0
    var count = 0
    for (i in 0 until n - K) {
        val substring = S.substring(i, i+K)
        println(substring)
        if (!isContainsDuplicate(substring)) {
            count++
        }
    }

    return count
}


fun isContainsDuplicate(string: String): Boolean {
    val asciiArray = IntArray(26) { 0 }

    for (ch in string) {
        val value = ch.toInt() - 96

        asciiArray[value]++
    }

    for (i in asciiArray) {
        if (i > 1) return true
    }

    return false
}