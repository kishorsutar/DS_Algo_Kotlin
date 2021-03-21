package com.kishor.kotlin.algo.algorithms.graph

import java.util.*

class Dijkstras {

    fun dijkstrasAlgorithm(start: Int, edges: List<List<List<Int>>>): List<Int> {

        val numberOfVertices = edges.size
        val minDist = MutableList<Int>(edges.size) { Int.MAX_VALUE }
        minDist[start] = 0

        val minDistPair = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until edges.size) {
            minDistPair.add(Pair(i, Int.MAX_VALUE))
        }

        val pq = PriorityQueue<Pair<Int, Int>>()
        pq.add(Pair(start, 0))

        while (pq.isNotEmpty()) {
            val (vertex, currentMin) = pq.remove()!!

            if (currentMin == Int.MAX_VALUE) break

            for (edge in edges[vertex]) {
                val (destination, distance) = edge

                val newPath = currentMin + distance
                val currentDistance = minDist[destination]
                if (newPath < currentDistance) {
                    minDist[destination] = newPath
                    pq.add(Pair(destination, newPath))
                }
            }
        }

        return minDist.map() { x -> if (x == Int.MAX_VALUE) -1 else x }

    }
    }