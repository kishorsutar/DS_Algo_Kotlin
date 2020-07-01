package com.kishor.algo.algorithms.graph

import java.util.*

fun main() {
    val adjL = AdajacenyList(7)
    adjL.accept(Scanner(System.`in`))
    adjL.display()
}

data class Edge(val src: Int, val dst: Int, val weight: Int) {
    override fun toString(): String {
        return "src: $src to dest: $dst weight: $weight"
    }
}

class AdajacenyList(vertCount: Int) {

    var vertList = MutableList(vertCount) { mutableListOf<Edge>() }

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