package com.kishor.algo.algorithms.dynamicprogramming

fun main() {
    val table = mutableMapOf<Int, Long>()
    table.put(0, 1)
    table.put(1, 1)
    println("Fibbo recursion ${fibbonacciRecursion(30)}")
    println("Fibbo Memoization ${fibonacciMemoization(100, table)}")
    println("Fibbo Tabbulation ${fibonacciTabulation(100, table)}")
}

// recursion
fun fibbonacciRecursion(n: Int): Int{

    if (n == 0) return 1
    if (n == 1) return 1

    return fibbonacciRecursion(n - 1) + fibbonacciRecursion(n - 2)

}

// top down approach with hashmap
fun fibonacciMemoization(n: Int, table: MutableMap<Int, Long>): Long {
    if (n == 0) return 1
    if (n == 1) return 1

    if (!table.containsKey(n))
        table[n] = fibonacciMemoization(n-1, table)+fibonacciMemoization(n-2,table)

    return table[n]!!
}

// bottom up approach with tabulation
fun fibonacciTabulation(n: Int, table: MutableMap<Int, Long>): Long {

    for (i in 2..n) {
        table[i] = table[i-1]!! + table[i-2]!!
    }

    return table[n]!!
}
