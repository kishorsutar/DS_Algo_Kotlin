package com.kishor.kotlin.algo.recursion


// naive solution
// O (2^n)
fun getNthFib(n: Int): Int {
    if (n == 2) {
        return 1
    }
    else if (n == 1){
        return 0
    }
    else {
        return getNthFib(n - 1) + getNthFib(n - 2)
    }
}

// Memoization
// Time: O(n)
// Space: O(n)
fun getNthFibMemo(n: Int): Int {
    // base case will be added in map
    val memoizedMap = mutableMapOf<Int, Int>()
    memoizedMap[1] = 0
    memoizedMap[2] = 1
    return memoize(n, memoizedMap)
}

fun memoize(n: Int, memoizedMap: MutableMap<Int, Int>): Int {
    if (n in memoizedMap) {
        return memoizedMap[n]!!
    }
    memoizedMap[n] = memoize(n - 1, memoizedMap) + memoize(n - 2, memoizedMap)
    return memoizedMap[n]!!
}


// Time: O(n)
// Space: O(1)
fun lastFib(n: Int): Int {
    val lastFib = arrayOf(0, 1)
    var counter = 3
    while (counter <= n) {
        val sum = lastFib[0] + lastFib[1]
        lastFib[0] = lastFib[1]
        lastFib[1] = sum
        counter++
    }

    return if (n > 1) lastFib[1] else lastFib[0]
}
