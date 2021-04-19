package com.kishor.kotlin.algo.problems.arrayandstrings

fun main(args : Array<String>) {
    println(matchingPairs("abcd", "adcb"))
}

fun matchingPairs(s: String, t: String): Int {
    val tStringMap = mutableMapOf<Char, Int>()

    for ((i, ele) in t.withIndex()) {
        tStringMap.put(ele, i)
    }
    var swap1 = 0
    var swap2 = 1
    for ((j, ele) in s.withIndex()) {
        if (ele != t[j] && ele in tStringMap) {
            if (swap1 == 0)
                swap1 = tStringMap[ele]!!
            else
                swap2 = tStringMap[ele]!!

        }
    }
    val array = s.toCharArray()
    val temp = s[swap1]
    array[swap1] = s[swap2]
    array[swap2] = temp

    var count = 0

    for ((j, ele) in array.withIndex()) {
        if (ele == t[j]) {
            count++
        }
    }

    return count
}