package com.kishor.kotlin.algo.algorithms.dynamicprogramming

class NumberOfWaysToTraverseGraph {

    //    O(n*m) graph traversal O(n*m) Space for matrix
    fun numberOfWaysToTraverseTheGraph(width: Int, height: Int): Int {
        val matrix = MutableList(height + 1) { MutableList(width + 1) { 0 } }

        for (widthIdx in 1..width) {
            for (heightIdx in 1..height) {
// edge case
                if (widthIdx == 1 || heightIdx == 1) {
                    matrix[heightIdx][widthIdx] = 1
                } else {
                    // confusion between height and width
                    val up = matrix[heightIdx - 1][widthIdx]
                    val left = matrix[heightIdx][widthIdx - 1]
// how to fill up data in matrix
                    matrix[heightIdx][widthIdx] = up + left
                }
            }
        }

        return matrix[height][width]
    }

    //    O(2 ^ n+m) (n+m)
    fun recursionNumberOfWays(width: Int, height: Int): Int {
        if (height == 1 || width == 1) return 0
        val left = width - 1
        val up = height - 1
        return recursionNumberOfWays(left, height) + recursionNumberOfWays(width, up)
    }

}