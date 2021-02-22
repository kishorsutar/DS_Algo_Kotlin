package com.kishor.kotlin.algo.algorithms.graph

import java.util.*


fun main() {
    val unionFind = KruskalsMST(9)
    val sc = Scanner(System.`in`)
    unionFind.accept(sc)
    unionFind.display()
//    println(unionFind.containsCycle())

    var sum = 0
    val mst: Array<Edge?> = unionFind.kruskal()
    for (e in mst) {
        println("Edge $e")
        sum += e!!.weight
    }
    println("\nTotal weight of MST = $sum")
    sc.close()
}

class KruskalsMST(val vertCount: Int) {
    var edgeCount: Int = 0

    private val mat = Array(vertCount) { Array(vertCount) { Int.MAX_VALUE } }
    private lateinit var edgeList : Array<Edge?>


   /* private data class Edge(val src: Int, val dst: Int, val weight: Int) {
        override fun toString(): String {
            return "src: $src to dest: $dst weight: $weight"
        }
    }*/

    fun accept(sc: Scanner) {
        println("Enter number of edges: ")
        edgeCount = sc.nextInt()
        println("Enter $edgeCount edges, src - dst - weight")
        edgeList = arrayOfNulls(edgeCount)
        for (i in 0 until edgeCount) {
            val src = sc.nextInt()
            val dst = sc.nextInt()
            val wt = sc.nextInt()
            mat[src][dst] = wt
            mat[dst][src] = wt
            edgeList[i] = Edge(src, dst, wt)
//            edgeArray[i] = (Edge(src, dst, wt))
        }
    }

    fun display() {

        for (oArray in mat) {
            println()
            for (iVal in oArray) {
                if (iVal == Int.MAX_VALUE) {
                    print("\t#")
                } else {
                    print("\t$iVal")
                }
            }
            println()
        }
    }

    fun find(v: Int, parent: IntArray): Int {
//        var t = v
//        for (i in parent) {
//            if (parent[i] != -1) {
//                t = parent[i]
//            }
//        }
//        return t

        var v = v
        while (parent[v] != -1) v = parent[v]
        return v
    }

    fun union(src: Int, dst: Int, parent: IntArray) {
        parent[src] = dst
    }

    private fun cotainsCycle(mst: Array<Edge?>, mstCount: Int): Boolean {
        val parent = IntArray(vertCount) {-1}
        for (i in 0 until mstCount) {
            val e = mst[i]
            val sr = find(e!!.src, parent)
            val dr = find(e.dst, parent)
            if (sr == dr) return true
            union(sr, dr, parent)
        }
        return false
    }

    internal fun kruskal() : Array<Edge?> {
        edgeList.sortWith(Comparator {e1, e2 -> e1!!.weight - e2!!.weight})
//        edgeArray.sort(Comparator { o1: Edge, o2: Edge ->  o1.weight - o2.weight})
//        val mst = MutableList(vertCount-1) {Edge(0, 0, 0)}
        val mst = arrayOfNulls<Edge>(vertCount - 1)// {Edge(0, 0, 0)}
        var i = 0
        var mstEdgeCount = 0


        while (mstEdgeCount < vertCount - 1) {
                val e = edgeList[i]
                i += 1

                mst[mstEdgeCount] = e
                mstEdgeCount++

                if (cotainsCycle(mst, mstEdgeCount)) {
                    mstEdgeCount -= 1
                    mst[mstEdgeCount] = null
                }
        }

        return mst
    }

}