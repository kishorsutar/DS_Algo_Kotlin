package com.kishor.kotlin.algo.algorithms.graph

import java.util.*


fun main() {
    println("${Solution().canFinish(2, arrayOf(arrayOf(0, 1)))}")
    println("${Solution().canFinish(2, arrayOf(arrayOf(0, 1), arrayOf(1, 0)))}")
}

data class Node(var inDegree: Int = 0, val outNode: MutableList<Int>)


class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<Array<Int>>): Boolean {

        if (prerequisites.isEmpty()) return true

        val graph = mutableMapOf<Int, Node>()

        for (relation in prerequisites) {
            val prevCourse = this.getCreateNode(graph, relation[1])
            val nextCourse = this.getCreateNode(graph, relation[0])

            prevCourse.outNode.add(relation[0])
            nextCourse.inDegree += 1
        }

        var totalDep = prerequisites.size
        val queue = ArrayDeque<Int>()

        for (entry in graph) {
            val node = entry.value
            if (node.inDegree == 0) {
                queue.add(entry.key)
            }
        }

        var removeEdge = 0

        while (queue.isNotEmpty()) {
            val course = queue.pop()

            for (nextCourse in graph[course]!!.outNode) {
                val childNode = graph[nextCourse]!!
                childNode.inDegree -= 1
                removeEdge += 1

                if (childNode.inDegree == 0) {
                    queue.add(nextCourse)
                }
            }
        }

        if (removeEdge != totalDep) {
            return false
        } else {
            return true
        }
    }

    fun getCreateNode(graph: MutableMap<Int, Node>, course: Int): Node {
        var node = Node(0, mutableListOf<Int>())
        if (course in graph) {
            node = graph[course]!!
        } else {
            graph[course] = node
        }

        return node
    }
}