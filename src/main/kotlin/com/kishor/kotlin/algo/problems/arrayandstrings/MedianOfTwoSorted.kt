package com.kishor.kotlin.algo.problems.arrayandstrings

import java.util.*


fun main() {
    val array1 = intArrayOf(1, 2)
    val array2 = intArrayOf(3, 4)
    println(findMedianSortedArrays(array1, array2))
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

    val pq = PriorityQueue<Int> (2) {
        a,b -> b.compareTo(a)
    }
    var i = 0
    var j = 0
    var k = 0
    val sortedArray = IntArray(nums1.size + nums2.size) { 0 }

    while (i < nums1.size && j < nums2.size) {
        if (nums1[i] < nums2[j]) {
            sortedArray[k] = nums1[i]
            i++
            k++
        } else {
            sortedArray[k] = nums2[j]
            j++
            k++
        }
    }

    while (i < nums1.size) {
        sortedArray[k] = nums1[i]
        i++
        k++
    }

    while (j < nums2.size) {
        sortedArray[k] = nums2[j]
        j++
        k++
    }

    return getMedian(sortedArray)

}

fun getMedian(sortedArray: IntArray): Double {
    if (sortedArray.size == 1) return sortedArray[0].toDouble()
    val mid = (0 + sortedArray.size) / 2
    println(mid)
    if ((0 + sortedArray.size) % 2 != 0) {
        val result = sortedArray[mid]
        return result.toDouble()
    } else {
        val result = (sortedArray[mid] + sortedArray[mid-1])/2.0
        return result
    }
}
