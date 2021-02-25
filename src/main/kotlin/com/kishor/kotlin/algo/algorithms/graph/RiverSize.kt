package com.kishor.kotlin.algo.algorithms.graph

import java.util.*

fun riverSizes(matrix: List<List<Int>>): List<Int> {

    val visited = List(matrix.size) { MutableList(matrix[0].size) { false } }
    val result = mutableListOf<Int>()

    for (i in 0 until matrix.size) {
        for (j in 0 until matrix[0].size) {
            if (visited[i][j]) {
                continue
            }
            traverse(matrix, visited, result, Pair(i, j))
        }
    }

    return result

}

fun traverse(matrix: List<List<Int>>, visited: List<MutableList<Boolean>>, result: MutableList<Int>, pair: Pair<Int, Int>) {
    val queue = ArrayDeque<Pair<Int, Int>>()

    queue.add(pair)
    var currentRiverSize = 0

    while (queue.isNotEmpty()) {
        var node = queue.poll()

        if (visited[node.first][node.second]) continue
        visited[node.first][node.second] = true
        if (matrix[node.first][node.second] == 0) continue
        currentRiverSize++
        val neighbours = getNeighbours(node, visited, matrix)
        for (neighbour in neighbours){
            queue.add(neighbour)
        }
    }
    if (currentRiverSize > 0)
        result.add(currentRiverSize)
}

fun getNeighbours(node: Pair<Int, Int>, visited: List<List<Boolean>>, matrix: List<List<Int>>): List<Pair<Int, Int>> {
// left, right, top, bottom

    val unvisitedArray = mutableListOf<Pair<Int, Int>>()
    val x = node.first
    val y = node.second
    if (x > 0 && !visited[x - 1][y]) {
        unvisitedArray.add(Pair(x-1, y))
    }
    if (x < matrix.size - 1 && !visited[x + 1][y]){
        unvisitedArray.add(Pair(x+1, y))

    }
    if (y > 0 && !visited[x][y - 1]) {
        unvisitedArray.add(Pair(x, y-1))
    }
    if (y < matrix[0].size - 1 && !visited[x][y + 1]){
        unvisitedArray.add(Pair(x, y + 1))
    }

    return unvisitedArray

}
