package com.kishor.kotlin.algo.sorting

import java.util.Comparator

import java.util.PriorityQueue
fun main() {
    val list  = mutableListOf( listOf(0, 2),
        listOf(1, 4),
        listOf(4, 6),
        listOf(0, 4),
        listOf(7, 8),
        listOf(9, 11),
        listOf(3, 10))
}

internal class MedianFinder {
    var minHeap: PriorityQueue<Int>? = null
    var maxHeap: PriorityQueue<Int>? = null
    fun addNum(num: Int) {
        minHeap!!.offer(num)
        maxHeap!!.offer(minHeap!!.poll())
        if (minHeap!!.size < maxHeap!!.size) {
            minHeap!!.offer(maxHeap!!.poll())
        }
    }

    fun findMedian(): Double {
        return if (minHeap!!.size > maxHeap!!.size) {
            minHeap!!.peek().toDouble()
        } else {
            (minHeap!!.peek() + maxHeap!!.peek()) / 2.0
        }
    }

    /** initialize your data structure here.  */
    init {
        minHeap = PriorityQueue()
        maxHeap = PriorityQueue(kotlin.Comparator { o1, o2 -> o2 - o1 })
    }
}
