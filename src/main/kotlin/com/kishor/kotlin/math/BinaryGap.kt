package com.kishor.kotlin.math

internal class Solution {
    fun binaryGap(N: Int): Int {
        val A = IntArray(32)
        var t = 0
        for (i in 0..31) if (N shr i and 1 != 0) A[t++] = i
        var ans = 0
        for (i in 0 until t - 1) ans = Math.max(ans, A[i + 1] - A[i])
        return ans
    }

    fun binaryGape(N: Int): Int {
        var last = -1
        var ans = 0
        for (i in 0..31) if (N shr i and 1 > 0) {
            if (last >= 0) ans = Math.max(ans, i - last)
            last = i
        }
        return ans
    }
}