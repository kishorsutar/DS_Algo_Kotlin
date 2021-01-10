package com.kishor.ds

import kotlin.math.min

fun main() {
    val list = MutableList(10) { Int.MAX_VALUE }
    Math.min(10, 5)

    var test: Pair<Int, Int> = Pair(1, 2)
}


class StringsAndArrays {

    val nums = IntArray(10) { 1 }

    var list = mutableListOf<String>()

    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String> {

        val theRange = mutableListOf<String>() // mutableList and MutableList
        var prev = lower - 1
        for (i in nums.indices) {
            val cur = if (i < nums.size) nums[i] else upper + 1
            if (prev + 1 <= cur - 1) {
                addTheRange(cur - 1, prev + 1, theRange)
            }
            prev = cur
        }

        return theRange

    }

    fun addTheRange(upper: Int, lower: Int, theRange: MutableList<String>) {
        if (lower == upper) {
            theRange.add("$lower")
        } else {
            theRange.add("$lower->$upper")
        }
    }

    fun largestRange(array: List<Int>): Pair<Int, Int> {
        // Write your code here.
        val sortedArray = array.sorted() // O(nlogn)
        var maxDiff = Int.MIN_VALUE
        var pairOfResult = Pair(-1, -1)
        for (i in 0 until sortedArray.size - 1) {
            if (sortedArray[i + 1] - sortedArray[i] > 1) {
                if (maxDiff <= sortedArray[i + 1] - sortedArray[i]) {
                    maxDiff = sortedArray[i + 1] - sortedArray[i]
                    pairOfResult = Pair(sortedArray[i], sortedArray[i + 1])
                }
            }
        }
        return pairOfResult
    }

    fun expressiveWords(S: String, words: Array<String>): Int {
        val stringMap = mutableMapOf<Char, Int>()
        var result = 0

        // form a string map
        formAMap(S, stringMap)

        // Iterate through array and compare
        for (s in words) {
            val wordMap = mutableMapOf<Char, Int>()
            formAMap(s, wordMap)
            // compare the map and increament the count
            if (isWordStretchy(wordMap, stringMap)) {
                result++
            }
        }

        return result
    }
}

fun formAMap(s: String, map: MutableMap<Char, Int>) {
    for (c in s.toCharArray()) {
        map[c] = map.getOrDefault(c, 0) + 1
    }
}

fun isWordStretchy(wordMap: MutableMap<Char, Int>, stringMap: MutableMap<Char, Int>): Boolean {
    for (entity in stringMap) {
        val key = entity.key
        val value = entity.value
        if (!wordMap.containsKey(key)) {
            return false
        }

        if (wordMap[key]!! > value) {
            return false
        } else if (wordMap[key]!! <= value) {
            continue
        }
    }

    return true
}