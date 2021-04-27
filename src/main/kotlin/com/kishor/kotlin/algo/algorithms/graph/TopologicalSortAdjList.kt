package com.kishor.kotlin.algo.algorithms.graph

import java.util.*


// Use Edge from {AdjacencyList.class}
//data class Edge(val source: Int, val dest: Int, val weight: Int)


fun dfs(
    i: Int,
    at: Int,
    visited: Array<Boolean>,
    ordering: Array<Int>,
    graph: MutableMap<Int, MutableList<Edge>>
): Int {
    visited[at] = true
    var te = i
    val edges = graph[at]
    if (edges != null) {
        for (edge in edges) {
            if (!visited[edge.dst]) {
                te = dfs(i, edge.dst, visited, ordering, graph)
            }
        }
    }

    ordering[i] = at
    return te - 1
}

fun topologicalSort(graph: MutableMap<Int, MutableList<Edge>>, numOfNode: Int): Array<Int> {

    val ordering = Array<Int>(numOfNode) { 0 }
    val visited = Array<Boolean>(numOfNode) { false }

    var i = numOfNode - 1

    for (at in 0 until numOfNode) {
        if (!visited[at]) {
            i = dfs(i, at, visited, ordering, graph)
        }
    }

    return ordering
}

fun dagShortestPath(graph: MutableMap<Int, MutableList<Edge>>, start: Int, numNodes: Int): Array<Int> {
    val topSort = topologicalSort(graph, numNodes)
    val distance = Array<Int>(numNodes) { -1 }

    distance[start] = 0

    for (i in 0 until numNodes) {
        val nodeIdx = topSort[i]
        if (distance[nodeIdx] != -1) {
            val adjacencyList = graph[nodeIdx]
            if (adjacencyList != null) {
                for (edge in adjacencyList) {
                    val newDest = distance[nodeIdx] + edge.weight
                    if (distance[edge.dst] == null) distance[edge.dst] = newDest
                    else distance[edge.dst] = kotlin.math.min(distance[edge.dst], newDest)
                }
            }
        }
    }

    return distance
}

// Example usage of topological sort
fun main(args: Array<String>) {

    // Graph setup
    val N = 7
    val graph = mutableMapOf<Int, MutableList<Edge>>()
    for (i in 0 until N) graph[i] = ArrayList()
    graph[0]!!.add(Edge(0, 1, 3))
    graph[0]!!.add(Edge(0, 2, 2))
    graph[0]!!.add(Edge(0, 5, 3))
    graph[1]!!.add(Edge(1, 3, 1))
    graph[1]!!.add(Edge(1, 2, 6))
    graph[2]!!.add(Edge(2, 3, 1))
    graph[2]!!.add(Edge(2, 4, 10))
    graph[3]!!.add(Edge(3, 4, 5))
    graph[5]!!.add(Edge(5, 4, 7))
    val ordering = topologicalSort(graph, N)

    // // Prints: [6, 0, 5, 1, 2, 3, 4]
    println(ordering)

    // Finds all the shortest paths starting at node 0
    val dists = dagShortestPath(graph, 0, N)

    // Find the shortest path from 0 to 4 which is 8.0
    println(dists[4])

    // Find the shortest path from 0 to 6 which
    // is null since 6 is not reachable!
    println(dists[6])
}