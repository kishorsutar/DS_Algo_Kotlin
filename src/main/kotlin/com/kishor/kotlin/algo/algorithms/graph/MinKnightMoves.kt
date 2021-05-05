package com.kishor.kotlin.algo.algorithms.graph

import java.util.HashSet
import java.util.LinkedList
import java.util.Queue
import java.util.Deque
import java.util.HashMap

internal class MinKnightMoves {

    fun minKnightMoves(x: Int, y: Int): Int {
        var x = x
        var y = y
        x = Math.abs(x)
        y = Math.abs(y)
        if (x == 0 && y == 0) return 0
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        val set: MutableSet<Pair<Int, Int>> = HashSet()
        queue.add(Pair(0, 0))
        set.add(queue.peek())
        val dirs = arrayOf(
            intArrayOf(2, 1),
            intArrayOf(-2, 1),
            intArrayOf(2, -1),
            intArrayOf(-2, -1),
            intArrayOf(1, 2),
            intArrayOf(-1, 2),
            intArrayOf(1, -2),
            intArrayOf(-1, -2)
        )
        var level = 0
        while (!queue.isEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val parent = queue.poll()
                for (dir in dirs) {
                    val x0: Int = Math.abs(parent.first + dir[0])
                    val y0: Int = Math.abs(parent.second + dir[1])
                    if (x0 == x && y0 == y) return level + 1
                    val child = Pair(x0, y0)
                    if (!set.contains(child)) {
                        set.add(child)
                        queue.add(child)
                    }
                }
            }
            level++
        }
        return level
    }

    fun minKnightMovesUsingArray(x: Int, y: Int): Int {
        // the offsets in the eight directions
        val offsets = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(2, -1),
            intArrayOf(1, -2),
            intArrayOf(-1, -2),
            intArrayOf(-2, -1),
            intArrayOf(-2, 1),
            intArrayOf(-1, 2)
        )

        // - Rather than using the inefficient HashSet, we use the bitmap
        //     otherwise we would run out of time for the test cases.
        // - We create a bitmap that is sufficient to cover all the possible
        //     inputs, according to the description of the problem.
        val visited = Array(605) { BooleanArray(605) }
        val queue: Deque<IntArray> = LinkedList()
        queue.addLast(intArrayOf(0, 0))
        var steps = 0
        while (queue.size > 0) {
            val currLevelSize = queue.size
            // iterate through the current level
            for (i in 0 until currLevelSize) {
                val curr = queue.removeFirst()
                if (curr[0] == x && curr[1] == y) {
                    return steps
                }
                for (offset in offsets) {
                    val next = intArrayOf(curr[0] + offset[0], curr[1] + offset[1])
                    // align the coordinate to the bitmap
                    if (!visited[next[0] + 302][next[1] + 302]) {
                        visited[next[0] + 302][next[1] + 302] = true
                        queue.addLast(next)
                    }
                }
            }
            steps++
        }
        // move on to the next level
        return steps
    }

// DFS

    private val memo: MutableMap<String, Int?> = HashMap()

    private fun dfs(x: Int, y: Int): Int {
        val key = "$x,$y"
        if (memo.containsKey(key)) {
            return memo[key]!!
        }
        return if (x + y == 0) {
            0
        } else if (x + y == 2) {
            2
        } else {
            val ret = Math.min(
                dfs(Math.abs(x - 1), Math.abs(y - 2)),
                dfs(Math.abs(x - 2), Math.abs(y - 1))
            ) + 1
            memo[key] = ret
            ret
        }
    }

    fun minKnightMovesDfs(x: Int, y: Int): Int {
        return dfs(Math.abs(x), Math.abs(y))
    }
}