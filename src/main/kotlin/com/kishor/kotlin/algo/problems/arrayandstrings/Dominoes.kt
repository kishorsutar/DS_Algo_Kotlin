package com.kishor.kotlin.algo.problems.arrayandstrings

fun numEquivDominoPairs(dominoes: Array<IntArray>): Int {
    val len = dominoes.size
    var count = 0
    val map = IntArray(91)
    for (i in 0 until len) {
        val domino = dominoes[i]
        val hash1 = 9 * domino[0] + domino[1]
        val hash2 = 9 * domino[1] + domino[0]
        count += map[hash1]
        count += if (hash1 != hash2) map[hash2] else 0
        map[hash1]++
    }
    return count
}