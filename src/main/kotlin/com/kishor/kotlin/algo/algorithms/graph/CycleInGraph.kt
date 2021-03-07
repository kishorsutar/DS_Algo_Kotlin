package com.kishor.kotlin.algo.algorithms.graph



fun main() {
    val edges = listOf(listOf(1, 3), listOf(2 ,3, 4), listOf(0), emptyList(), listOf(2, 5), emptyList())
    cycleInGraph(edges)
}

fun cycleInGraph(edges: List<List<Int>>): Boolean {
    val numberOfEdges = edges.size
    val visited = BooleanArray(numberOfEdges) { false }
    val recStack = BooleanArray(numberOfEdges) { false }

    for (node in 0 until numberOfEdges) {

        if (visited[node]) continue
        val containsCycle = isNodeInCycle(edges, node, visited, recStack)
        if (containsCycle) return true
    }

    return false
}


fun isNodeInCycle(edges: List<List<Int>>, node: Int, visited: BooleanArray, recStack: BooleanArray): Boolean {
    visited[node] = true
    recStack[node] = true

    val neighbours = edges[node]

    for (neighbour in neighbours) {
        if (!visited[neighbour]) {
            val containsCycle = isNodeInCycle(edges, neighbour, visited, recStack)
            if (containsCycle) {
                return true
            }
        } else if (recStack[neighbour]) {
            return true
        }
    }

    recStack[node] = false
    return false
}

