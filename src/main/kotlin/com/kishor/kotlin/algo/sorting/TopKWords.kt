package com.kishor.kotlin.algo.sorting

import java.util.*

fun main() {
    println(topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), k = 2))
}
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val map = mutableMapOf<String, Int>()
        for (word in words) {
            map.put(word, map.getOrDefault(word, 0) + 1)
        }

        val pq = PriorityQueue<String>() { w1: String?, w2: String ->
            if (map[w1]!! == (map[w2]!!)) w2.compareTo(
                w1!!
            ) else map.get(w1)!! - map.get(w2)!!
        }


        val topKWords = mutableListOf<String>()

        for (word in map.keys) {
            pq.offer(word)
            if (pq.size > k) pq.poll()
        }

        while (pq.isNotEmpty()) {
            topKWords.add(pq.poll())
        }
        return topKWords.reversed()

    }
