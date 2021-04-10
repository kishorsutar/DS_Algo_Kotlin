package com.kishor.kotlin.ds

import java.util.*

data class Item(val test: Int) : Comparable<Item> {
    override fun compareTo(other: Item): Int {
        return this.test.compareTo(other.test)
    }
}

fun main() {
    val minHeap = MinHeap()
    minHeap.checkPriorityQueue()
    println(minHeap.priorityQueue.peek().test)
}

class MinHeap {

    var priorityQueue = PriorityQueue<Item>()

    fun checkPriorityQueue() {
        priorityQueue.add(Item(test = 89))
        priorityQueue.add(Item(test = 9))
        priorityQueue.add(Item(test = -1))
        priorityQueue.add(Item(test = 890))
    }

    val compareByValue = kotlin.Comparator<Int> { o1, o2 ->
        if (o1 > o2) 1
        else if (o1 < o2) -1
        else 0
    }
    var heap = PriorityQueue { n1: Int, n2: Int -> n1 - n2 }
    val pqs = PriorityQueue<Int> { n1, n2 -> n1 - n2 }
    val pq = PriorityQueue<Int>(2, compareByValue)

    val array = arrayOf(2, 5, 7, 93, 14, 78, 3)

}

fun minMeetingRooms(intervals: Array<IntArray>): Int {
    if (intervals.isEmpty()) return 0

    val pq = PriorityQueue<Int> { n1, n2 -> n1 - n2 }

    intervals.sortWith(kotlin.Comparator { a: IntArray, b: IntArray -> a[0] - b[0] })

    pq.add(intervals[0][1])

    for (i in intervals.indices) {
        if (intervals[i][0] >= pq.peek()) {
            pq.poll()
        }

        pq.add(intervals[i][1])
    }

    return pq.size
}

fun minMeetingRooms2(intervals: Array<IntArray>): Int {

    // Check for the base case. If there are no intervals, return 0
    if (intervals.size == 0) {
        return 0
    }

    // Min heap
    val allocator = PriorityQueue<Int>(
        intervals.size
    ) { a, b -> a - b }

    // Sort the intervals by start time
    Arrays.sort(
        intervals
    ) { a, b -> a[0] - b[0] }

    // Add the first meeting
    allocator.add(intervals[0][1])

    // Iterate over remaining intervals
    for (i in 1 until intervals.size) {

        // If the room due to free up the earliest is free, assign that room to this meeting.
        if (intervals[i][0] >= allocator.peek()) {
            allocator.poll()
        }

        // If a new room is to be assigned, then also we add to the heap,
        // If an old room is allocated, then also we have to add to the heap with updated end time.
        allocator.add(intervals[i][1])
    }

    // The size of the heap tells us the minimum rooms required for all the meetings.
    return allocator.size
}