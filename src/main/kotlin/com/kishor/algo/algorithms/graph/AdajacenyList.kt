package com.kishor.algo.algorithms.graph

import java.util.*

fun main() {
//    val adjL = AdajacenyList(7)
//    adjL.accept(Scanner(System.`in`))
//    adjL.display()

    val visited: BooleanArray = BooleanArray(7) { false }

    val adjacencyList = AdjacencyList()
    val graph = adjacencyList.buildGraph()
//    adjacencyList.dfs(graph, 0, visited)
//    adjacencyList.dfs(graph, 0, 7)
    adjacencyList.breadthFirstSearch(graph, 0, 7)

}

data class Edge(val src: Int, val dst: Int, val weight: Int) {
    override fun toString(): String {
        return "src: $src to dest: $dst weight: $weight"
    }
}


class AdajacenyList(vertCount: Int) {

    private var vertList = MutableList(vertCount) { mutableListOf<Edge>() }

    fun accept(sc: Scanner) {
        println("Enter edge count: ")
        val edgeCount = sc.nextInt()
        for (i in 0 until edgeCount) {
            val src = sc.nextInt()
            val dst = sc.nextInt()

            val srcEdge = Edge(src, dst, 1)
            val dstEdge = Edge(dst, src, 1)
            vertList[src].add(dstEdge)
            vertList[dst].add(srcEdge)
        }
    }

    fun display() {
//        for (i in 0 until vertList.size) {
//            println()
//            for (j in 0 until vertList[i].size) {
//                println("\t${vertList[i][j]}")
//            }
//        }

        for (i in vertList.indices) {
            print("v$i\t")

            for (e in vertList[i]) print("$e --> ")
            println()
        }
    }
}


class AdjacencyList() {

    fun buildGraph(): MutableMap<Int, List<Edge>> {
        val graph = mutableMapOf<Int, List<Edge>>()

        val edge1 = Edge(1, 0, 1)
        val edge2 = Edge(2, 0, 1)
        val edge3 = Edge(6, 0, 1)
        val edge4 = Edge(1, 2, 1)
        val edge5 = Edge(1, 4, 1)
        val edge6 = Edge(3, 4, 1)
        val edge7 = Edge(3, 5, 1)
        val edge8 = Edge(6, 5, 1)
        val edge9 = Edge(4, 6, 1)

        graph[0] = listOf(edge1, edge2, edge3)
        graph[2] = listOf(edge4)
        graph[4] = listOf(edge5, edge6)
        graph[5] = listOf(edge7, edge8)
        graph[6] = listOf(edge9)

        return graph
    }

    data class Edge(val to: Int, val from: Int, val id: Int)

    fun dfs(graph: MutableMap<Int, List<Edge>>, at: Int, visited: BooleanArray) {

        if (visited[at]) return

        visited[at] = true
        val listOfNeighbours = graph[at]
        println("Recursive visit $at")

        listOfNeighbours?.let {
            for (neighbour in listOfNeighbours) {
                dfs(graph, neighbour.to, visited)
            }
        }

    }

    fun dfs(graph: MutableMap<Int, List<Edge>>, rootId: Int, numberOfVertex: Int) {
        val visited = BooleanArray(numberOfVertex) { false }
        val stack = ArrayDeque<Int>()
        stack.push(rootId)
        println("Iterative Visit $rootId")

        while (!stack.isEmpty()) {
            val current = stack.pop()
            val list = graph[current]

            list?.let {
                for (edge in list) {
                    if (!visited[edge.to]) {
                        stack.push(edge.to)
                        visited[edge.to] = true
                        println("Iterative Visit ${edge.to}")
                    }
                }
            }
        }
    }

    fun breadthFirstSearch(graph: MutableMap<Int, List<Edge>>, rootId: Int, numberOfVertex: Int) {
        val visited = BooleanArray(numberOfVertex) { false }
        val queue = ArrayDeque<Int>()

        queue.offer(rootId)
        println("Visited $rootId")
        visited[rootId] = true

        while (queue.isNotEmpty()) {
            val current = queue.poll()
            val list = graph[current]

            list?.let {
                for (edge in list) {
                    if (!visited[edge.to]) {
                        queue.offer(edge.to)
                        println("Visited ${edge.to}")
                        visited[edge.to] = true
                    }
                }
            }
        }
    }

}


//9
//0 1
//0 2
//0 6
//1 2
//1 4
//3 4
//3 5
//6 5
//4 6