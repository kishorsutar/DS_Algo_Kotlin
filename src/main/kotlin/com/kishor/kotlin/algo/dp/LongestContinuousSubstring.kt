package com.kishor.kotlin.algo.dp

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(longestContinuousSubstring("00101001010", 2))
}

fun longestContinuousSubstring(s: String, k: Int): Int {
    var res = 0

    for (d in '0'..'9') {
        var totalCnt = 0
        for (i in 0 until s.length) {
            if (s[i] == d) totalCnt++
        }

        var start = 0
        var curCnt = 0

        for(i in 0 until s.length) {
            if (s[i] == d) curCnt++
            var winLength = i - start + 1
            var nonDCnt = winLength - curCnt
            var restCnt = totalCnt - curCnt
            while (nonDCnt > min(restCnt, k)) {
                if (s[start] == d) curCnt--
                start++
                winLength = i - start + 1
                nonDCnt = winLength - curCnt
                restCnt - totalCnt - curCnt
            }
            res = max(res, i - start + 1)
        }
    }
    return res
}