package com.kishor.algo.problems.arrayandstrings

import java.util.*
import kotlin.text.*

// Complete the substrCount function below.
/**
- get all combinations of the strings / O(n^2)
- check all chars are same or all except one in the middle O(m)
- return the count which follows the above condition
O(n^2m)
 */
fun substrCount(n: Int, s: String): Long {
    var count = 0L
    val listOfString = getAllCombination(s)
    for (string in listOfString) {
        if (isSpecialString(string)) {
            count++
        }
    }
    return count
}

fun isSpecialString(string: String): Boolean {
    if (string.length == 1) return true
    val char = string[0]
    val mid = 0 + (string.length - 1)/2

    for (i in 1 until string.length) {
        if (i == mid) continue
        if (string[i] != char) {
            return false
        }
    }
    return true
}

fun getAllCombination(s: String): List<String> {
    val subStringList = mutableListOf<String>()
    for (i in s.indices) {
        subStringList.add(s[i].toString())
        for (j in i+1 until s.length) {
            subStringList.add(s.substring(i, j+1))
        }
    }
    return subStringList
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = substrCount(n, s)

    println(result)
}
