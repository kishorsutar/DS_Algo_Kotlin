package com.kishor.kotlin.algo.problems.arrayandstrings

import java.util.HashMap

fun subarraysWithKDistinct(nums: IntArray, K: Int): Int {
    val n = nums.size
    var count = 0
    val distinctMap = HashMap<Int, Int>()
    var left = 0
    var right = 0 // i is starting pointer and j is end pointer
    while (right < n && left < n) {
        distinctMap[nums[right]] = distinctMap.getOrDefault(nums[right], 0) + 1
        while (distinctMap.size > K) {
            distinctMap[nums[left]] = distinctMap[nums[left]]!! - 1
            if (distinctMap[nums[left]]!! <= 0) {
                distinctMap.remove(nums[left])
            }
            left++
        }
        val prev = left
        while (left <= right && distinctMap.size == K) { //i==j incase of K=1
            distinctMap[nums[left]] = distinctMap[nums[left]]!! - 1
            if (distinctMap[nums[left]]!! <= 0) {
                distinctMap.remove(nums[left])
            }
            left++
            count++
        }
        while (prev != left) {
            left--
            distinctMap[nums[left]] = distinctMap.getOrDefault(nums[left], 0) + 1
            // now get back to the state you previously were
        }
        right++
    }
    return count
}