package com.kishor.kotlin.algo.problems.arrayandstrings

var mod = 1000000007
lateinit var arr: Array<IntArray>
fun knightDialer(n: Int): Int {
    arr = arrayOf(
        intArrayOf(4, 6),
        intArrayOf(6, 8),
        intArrayOf(7, 9),
        intArrayOf(8, 4),
        intArrayOf(0, 3, 9),
        intArrayOf(),
        intArrayOf(0, 1, 7),
        intArrayOf(2, 6),
        intArrayOf(1, 3),
        intArrayOf(2, 4)
    )
    val dp = Array(n) { IntArray(10) }
    dp[0] = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
    for (i in 0 until n - 1) {
        for (j in 0..9) {
            for (next in arr[j]) {
                dp[i + 1][next] = (dp[i + 1][next] + dp[i][j]) % mod
            }
        }
    }
    var res = 0
    for (j in 0..9) res = (res + dp[n - 1][j]) % mod
    return res
}