package com.kishor.kotlin.algo.search

fun climbingLeaderboard(scores: IntArray, player: IntArray): IntArray? {
    val scoreSize = scores.size
    val playerScoresSize = player.size
    val ranking = IntArray(playerScoresSize)
    val rank = IntArray(scoreSize)
    rank[0] = 1
    for (i in 1 until scoreSize) {
        if (scores[i] == scores[i - 1]) {
            rank[i] = rank[i - 1]
        } else {
            rank[i] = rank[i - 1] + 1
        }
    }
    for (i in 0 until playerScoresSize) {
        val aliceScore = player[i]
        if (aliceScore > scores[0]) {
            ranking[i] = 1
        } else if (aliceScore < scores[scoreSize - 1]) {
            ranking[i] = rank[scoreSize - 1] + 1
        } else {
            val index = binarySearch(scores, aliceScore)
            ranking[i] = rank[index]
        }
    }
    return ranking
}

private fun binarySearch(a: IntArray, key: Int): Int {
    var lo = 0
    var hi = a.size - 1
    while (lo <= hi) {
        val mid = lo + (hi - lo) / 2
        if (a[mid] == key) {
            return mid
        } else if (a[mid] < key && key < a[mid - 1]) {
            return mid
        } else if (a[mid] > key && key >= a[mid + 1]) {
            return mid + 1
        } else if (a[mid] < key) {
            hi = mid - 1
        } else if (a[mid] > key) {
            lo = mid + 1
        }
    }
    return -1
}