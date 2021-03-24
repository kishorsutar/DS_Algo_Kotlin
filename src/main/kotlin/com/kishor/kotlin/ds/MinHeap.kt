package com.kishor.kotlin.ds

import java.util.*

data class Item(val test: Int): Comparable<Item> {
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
}