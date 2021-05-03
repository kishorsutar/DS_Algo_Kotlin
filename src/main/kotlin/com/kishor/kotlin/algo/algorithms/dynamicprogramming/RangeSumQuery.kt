package com.kishor.kotlin.algo.algorithms.dynamicprogramming

private var dp = mutableListOf<MutableList<Int>>()

fun NumMatrix(matrix: Array<IntArray>) {
    if (matrix.size == 0 || matrix[0].size == 0) return
    dp = MutableList(matrix.size + 1) { MutableList<Int>(matrix[0].size + 1) { 0 } }
    for (r in matrix.indices) {
        for (c in 0 until matrix[0].size) {
            dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c]
        }
    }
}

fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {
    return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1]
}