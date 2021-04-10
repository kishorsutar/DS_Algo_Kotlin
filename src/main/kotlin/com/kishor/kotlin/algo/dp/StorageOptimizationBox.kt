package com.kishor.kotlin.algo.dp

import java.util.ArrayList


fun optimizatingBoxWeights(arr: List<Int>): List<Int>? {
    val ans: MutableList<Int> = ArrayList()
    arr.sorted().reversed()
    val N = arr.size
    var setA = 0
    for (i in 0 until N) {
        var j = i
        var setB = 0
        val value = arr[i]
        setA += value
        ans.add(value)
        while (j < N) {
            setB += arr[j++]
        }
        if (setA >= setB) break
    }
    return ans
}


internal object Result {
    fun numberOfItems(str: String, startIndices: List<Int>, endIndices: List<Int>): List<Int> {
        val list = mutableListOf<Int>()
        for (i in startIndices.indices) {
            val s = startIndices[i]
            val e = endIndices[i]
            var f1 = false
            var value = 0
            var ans = 0
            for (j in s..e) {
                if (!f1 && (str[j] == '|')) {
                    f1 = true
                } else if (f1 && str[i] == '*') {
                    value++
                } else if (f1 && str[i] == '|') {
                    ans += value
                    list.add(ans)
                    value = 0
                }
            }
        }
        return list
    }
}