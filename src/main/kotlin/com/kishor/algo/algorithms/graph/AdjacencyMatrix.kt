package com.kishor.algo.algorithms.graph

import java.util.*

fun main() {
    val adjM = AdjacencyMatrix(7)
    adjM.accept(Scanner(System.`in`))
    adjM.display()
    adjM.dfsTrav(0)
    println("${adjM.dfsIsConnected(0)}")
}

class AdjacencyMatrix(var vertCount: Int = 0) {

    private var edgeCount: Int = 0
    private var matrix = Array(vertCount) { Array(vertCount) { 0 } }

    fun accept(sc: Scanner) {
        println("Enter edge count : ")
        edgeCount = sc.nextInt()
        println("Enter number of " + edgeCount + "src - - dst")

        for (i in 0 until edgeCount) {
            val src = sc.nextInt()
            val dst = sc.nextInt()
            matrix[src][dst] = 1
            matrix[dst][src] = 1
        }
    }

    fun display() {
        for (i in 0 until vertCount) {
            println()
            for (j in 0 until edgeCount) {
                print("\t${matrix[i][j]} ")
            }
            println()
        }
    }

    fun dfsTrav(start: Int) {
        val stack = Stack<Int>()
        val visited = BooleanArray(vertCount) { false }

        stack.push(start)
        visited[start] = true

        while (stack.isNotEmpty()) {
            val vert = stack.pop()

            print("\t $vert")
            for (i in 0 until vertCount) {
                if (!visited[i]
                    && matrix[vert][i] == 1
                ) {
                    stack.push(i)
                    visited[i] = true
                }
            }
        }
        println()
    }

    fun dfsIsConnected(start: Int): Boolean {
        val stack = Stack<Int>()
        val visited = BooleanArray(vertCount) { false }
        var count = 0
        stack.push(start)
        visited[start] = true
        count++
        while (stack.isNotEmpty()) {
            val vert = stack.pop()

            print("\t $vert")
            for (i in 0 until vertCount) {
                if (!visited[i]
                    && matrix[vert][i] == 1
                ) {
                    stack.push(i)
                    visited[i] = true
                    count++
                    if (count == vertCount) {
                        return true
                    }
                }
            }
        }
        println()

        return false
    }

}

//Input data
/*
7
0 1
0 2
0 3
1 2
1 4
3 4
3 5
*/