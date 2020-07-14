package com.kishor.algo.problems.arrayandstrings

import kotlin.math.max


fun main() {
//    lengthOfLongestSubstring("abcabcbb")
    println("${findLongestSubstringLength("abcabcbb")}")
    println("${longestSubstringLength("abcabcbb")}")
}

fun lengthOfLongestSubstring(s: String): Int {
    var count = 0
    if (s.length == 0) return count
    val set = hashSetOf<Char>()
    var i = 0
    var j = 0

    while (i < s.length && j < s.length) {
        println("$i and $j")
        println(set.size)
        if (!set.contains(s[j])) {
            set.add(s[j++])
            count = max(j - i, count)
        } else {
            set.remove(s[i++])
        }
    }
    return count
}

fun findLongestSubstringLength(s: String) : Int {
    val n = s.length
    val map = hashMapOf<Char, Int>()
    var ans = 0

    var i = 0
    for (j in 0 until n) {
        if(map.contains(s[j])) {
            i = max(i, map[s[j]] as Int)
        }
        ans = max(ans, j - i + 1)
        map[s[j]] = j + 1
    }

    return ans
}

fun longestSubstringLength(s: String): Int {
    val n = s.length
    val index = IntArray(128) {0}
    var ans = 0
    var i = 0
    for (j in s.indices) {
        i = Math.max(index[s[j].toInt()], i)
        ans = Math.max(ans, j - i + 1)
        index[s[j].toInt()] = j + 1

    }

    return ans
}

