package com.kishor.kotlin.algo.algorithms.graph

import java.util.Stack

import java.util.Arrays


internal class BipartteteGraph {
    fun isBipartite(graph: Array<IntArray>): Boolean {
        val n = graph.size
        val color = IntArray(n)
        Arrays.fill(color, -1)
        for (start in 0 until n) {
            if (color[start] == -1) {
                val stack = Stack<Int>()
                stack.push(start)
                color[start] = 0
                while (!stack.empty()) {
                    val node = stack.pop()
                    for (nei in graph[node!!]) {
                        if (color[nei] == -1) {
                            stack.push(nei)
                            color[nei] = color[node] xor 1
                        } else if (color[nei] == color[node]) {
                            return false
                        }
                    }
                }
            }
        }
        return true
    }
}