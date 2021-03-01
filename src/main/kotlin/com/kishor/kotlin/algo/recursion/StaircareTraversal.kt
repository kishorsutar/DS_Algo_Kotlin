package com.kishor.kotlin.algo.recursion

import kotlin.math.min

//Time: O(k^n) - O(n) space
fun staircaseTraversal(height: Int, maxSteps: Int) {
    numberOfWaysToTop(height, maxSteps)
}

fun numberOfWaysToTop(height: Int, maxStep: Int): Int {
    if (height <= 1) return 1

    var numberOfWays = 0
    for (step in 1 until min(maxStep, height) + 1) {
        numberOfWays += numberOfWaysToTop(height - step, maxStep)
    }
    return numberOfWays
}

// Time O(k * n), O(n) space

fun staircaseTraversalMemo(height: Int, maxSteps: Int) {
    numberOfWaysToTopMemo(height, maxSteps)
}

fun numberOfWaysToTopMemo(height: Int, maxStep: Int, memoize: MutableMap<Int, Int> = mutableMapOf<Int, Int>()): Int {
    if (height in memoize) return memoize[height]!!

    var numberOfWays = 0
    for (step in 1 until min(maxStep, height) + 1) {
        numberOfWays += numberOfWaysToTopMemo(height - step, maxStep)
    }

    memoize[height] = numberOfWays

    return numberOfWays
}
