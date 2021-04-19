package com.kishor.kotlin.algo.problems.arrayandstrings

fun main(args : Array<String>) {
    println(minLengthSubstring("dcbefebce", "fd"))
}

fun minLengthSubstring(s: String, t: String): Int {

    val countMap = mutableMapOf<Char, Int>()

    for (ch in t) {
        countMap[ch] = countMap.getOrDefault(ch, 0) + 1
    }

    var start = 0
    var currLen = t.length
    var minWindow = Int.MAX_VALUE
    var minStart = 0

    var i = 0

    while (i < s.length) {

        if (!countMap.contains(s[i])) {
            i++
            continue
        }

        var value = countMap[s[i]]!!

        if (value > 0) {
            currLen--
        }
        value --
        countMap[s[i]] = value

        while (currLen == 0) {
            if (minWindow > i - start + 1) {
                minWindow = i - start + 1
                minStart = start
            }
            if (s[i] in countMap) {
                var value1 = countMap[s[i]]!!
                if (value1 == 0) {
                    break
                } else {
                    countMap[s[start]] = value1 + 1
                }

            }
            start++
        }

        i++
    }

    return if (minWindow != Int.MAX_VALUE) minWindow - minStart else -1
}
