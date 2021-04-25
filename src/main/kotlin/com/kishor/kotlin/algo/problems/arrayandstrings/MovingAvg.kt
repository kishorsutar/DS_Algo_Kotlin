package com.kishor.kotlin.algo.problems.arrayandstrings

import java.util.*

internal class MovingAverage(var size: Int) {
    var windowSum = 0
    var count = 0
    var queue = ArrayDeque<Int>()
    fun next(`val`: Int): Double {
        ++count
        // calculate the new sum by shifting the window
        queue.add(`val`)
        val tail = if (count > size) queue.poll() as Int else 0
        windowSum = windowSum - tail + `val`
        return windowSum * 1.0 / Math.min(size, count)
    }
}