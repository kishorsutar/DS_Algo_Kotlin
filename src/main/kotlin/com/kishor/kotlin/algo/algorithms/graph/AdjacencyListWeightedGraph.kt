package com.kishor.kotlin.algo.algorithms.graph


import java.util.*

fun main() {
    val adjL = AdjacencyListWeightedGraph(7)
    val sc = Scanner(System.`in`)
    adjL.accept(sc)
    adjL.display()
    sc.close()

}

data class EdgeW(val src: Int, val dst: Int, val weight: Int) {
    override fun toString(): String {
        return "src: $src to dest: $dst weight: $weight"
    }
}

class AdjacencyListWeightedGraph(val vertCount: Int) {

    var vertList = MutableList(vertCount) { mutableListOf<EdgeW>() }
//    var vertList = ArrayList<ArrayList<EdgeW>>()
//    var vertList = mutableListOf<MutableList<EdgeW>>()


    fun accept(sc: Scanner) {
//        for (i in 0 until vertCount) {
//            val vart = ArrayList<EdgeW>()
//            vertList.add(vart)
//        }

        println("Enter edge count: ")
        val edgeCount = sc.nextInt()
        for (i in 0 until edgeCount) {
            val src = sc.nextInt()
            val dst = sc.nextInt()
            val w = sc.nextInt()

            val srcEdge = EdgeW(src, dst, w)
            val dstEdge = EdgeW(dst, src, w)
            vertList[src].add(dstEdge)
            vertList[dst].add(srcEdge)
        }
    }

    fun display() {

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

/*
7
0 1 7
0 2 4
0 3 8
1 2 9
1 4 5
3 4 6
3 5 2  // 6 5 2
*/