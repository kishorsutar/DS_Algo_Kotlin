package com.kishor.algo.algorithms.graph

import java.util.*

fun main() {
    val adjacencyMatrixWeightedGraph = UnionFind(6)
    adjacencyMatrixWeightedGraph.accept(Scanner(System.`in`))
    adjacencyMatrixWeightedGraph.display()
}



class UnionFind(val vertCount: Int) {

    private data class Edge(val src: Int, val dst: Int, val weight: Int) {
        override fun toString(): String {
            return "src: $src to dest: $dst weight: $weight"
        }
    }


    var matrix = Array(vertCount) { Array(vertCount) {Int.MAX_VALUE} }
    private val edgeList = mutableListOf<Edge>()

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
            edgeList.add(Edge(src, dst, weight))
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

    fun find(v: Int, parent: IntArray) : Int {

        for ( ele in parent.indices) {
            if (ele == -1) {
                return  ele
            }
        }
        return v

//        var ver = -1
//        while (parent[v] != -1) {
//            ver = parent[v]
//        }
//        return ver
    }

    fun union(src: Int, dst: Int, parent: IntArray) {
        parent[src] = dst
    }

    fun containsCycle() : Boolean {


        return false
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
