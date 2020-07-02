package com.kishor.algo.algorithms.graph

import java.util.*

fun main() {
    val adjacencyMatrixWeightedGraph = AdjacencyMatrixWeightedGraph(6)
    adjacencyMatrixWeightedGraph.accept(Scanner(System.`in`))
    adjacencyMatrixWeightedGraph.display()
}

class AdjacencyMatrixWeightedGraph(val vertCount: Int) {

    var matrix = Array(vertCount) { Array(vertCount) {Int.MAX_VALUE} }

    fun accept(sc: Scanner) {
        println("Enter the edge count:")
        val edgeCount = sc.nextInt()
        println("Enter number of " + edgeCount + "src - - dst --- weight")
        for (i in  0..edgeCount) {
            val src = sc.nextInt()
            val dst = sc.nextInt()
            val weight = sc.nextInt()

            matrix[src][dst] = weight
            matrix[dst][src] = weight
        }
    }

    fun display() {
        for ((i, element) in matrix.withIndex()) {
            println()
            for (j in element.indices) {
                if(matrix[i][j] == Int.MAX_VALUE) {
                    print("\t#")
                } else {
                    print("\t${matrix[i][j]}")
                }
            }
            println()
        }
    }
}

/*
7
0 1 7
0 2 4
0 3 8
1 2 9
1 4 5
3 4 6
3 5 2
*/
