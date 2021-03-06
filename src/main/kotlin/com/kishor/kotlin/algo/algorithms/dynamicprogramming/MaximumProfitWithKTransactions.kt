package com.kishor.kotlin.algo.algorithms.dynamicprogramming

import kotlin.math.max

class MaximumProfitWithKTransactions {

    fun maxProfitWithKTransactions(prices: List<Int>, k: Int): Int {

        if (prices.size == 0) return 0
        val profit = MutableList(k + 1) { MutableList<Int>(prices.size) { 0 } }

        for (t in 1 until k + 1) {
            var maxThusFar = Int.MIN_VALUE
            for (d in 1 until prices.size) {
                maxThusFar = max(maxThusFar, profit[t-1][d-1] - prices[d-1])
                profit[t][d] = max(profit[t][d-1], maxThusFar + prices[d])
            }
        }
        return profit[k][prices.size - 1]
    }
}