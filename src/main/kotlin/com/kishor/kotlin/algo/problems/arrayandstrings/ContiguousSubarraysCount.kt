package com.kishor.kotlin.algo.problems.arrayandstrings

fun main(args : Array<String>) {
    // Call countSubarrays() with test cases here
    println(countSubarrays(arrayOf(3,4,1,6,2)))
    println(countSubarrays(arrayOf(2, 4, 7, 1, 5, 3)))

   assert(countSubarrays(arrayOf(2, 4, 7, 1, 5, 3)) == listOf(1, 2, 6, 1, 3, 1))
}

fun countSubarrays(args: Array<Int>): List<Int> {

    val outPut = mutableListOf<Int>()

    for ((idx, ele) in args.withIndex()) {
        var leftArray = 0
        var rightArray = 0
        var left = idx - 1
        var right = idx + 1
        while (left >= 0 && args[idx] > args[left]) {
            left--
        }

        while ((right < args.size) && args[idx] > args[right]) {
                right++
            }

            leftArray = idx - left
            rightArray = right - idx

            outPut.add(idx, leftArray + rightArray - 1)

    }

    return outPut
}