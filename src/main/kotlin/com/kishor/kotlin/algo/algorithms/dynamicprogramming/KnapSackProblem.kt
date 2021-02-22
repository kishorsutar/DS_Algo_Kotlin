package com.kishor.kotlin.algo.algorithms.dynamicprogramming

import kotlin.math.max

fun main() {
    val items = mutableListOf<List<Int>>()
    items.add(listOf(2, 2))
    items.add(listOf(3, 3))
    items.add(listOf(4, 10))
    items.add(listOf(5, 7))
    items.add(listOf(2, 4))

    println(knapsackProblem(items, 7))
}

fun knapsackProblem(items: List<List<Int>>, capacity: Int): Pair<Int, List<Int>> {
    val knapSack = List(items.size + 1) { MutableList<Int>(capacity + 1) { 0 } }
    for (i in 1 until items.size + 1) {
        val currentWeight = items[i - 1][1]
        val currentValue = items[i - 1][0]
        for (c in 0 until capacity + 1) {
            if (currentWeight > c) {
                knapSack[i][c] = knapSack[i - 1][c]
            } else {
                val potentialMax = knapSack[i - 1][c - currentWeight] + currentValue
                knapSack[i][c] = max(potentialMax, knapSack[i - 1][c])
            }
        }
    }

    return getKnapSackItems(knapSack, knapSack[items.size][capacity], items)

}
fun getKnapSackItems(knapSack: List<MutableList<Int>>, weight: Int, items: List<List<Int>>): Pair<Int, List<Int>> {
    val sequence = mutableListOf<Int>()
    val pair = Pair(weight, sequence)
    var i = knapSack.size - 1
    var c = knapSack[0].size - 1
    while (i > 0) {
        if (knapSack[i][c] == knapSack[i-1][c]) {
            i--
        } else {
            sequence.add(i - 1)
            c -= items[i-1][1]
            i--
        }
        if (c == 0) {
            break
        }
    }
    return pair

}