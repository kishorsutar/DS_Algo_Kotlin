package com.kishor.kotlin.algo.recursion

class NumberOfBinaryTopologies {

    fun numberOfBinaryTreeTopology(n: Int): Int {
        if (n == 0)
            return 1

        var numberOfTopologies = 0

        for (leftTopology in 0 until n) {
            val rightTopology = n - 1 - leftTopology
            val leftSubtree = numberOfBinaryTreeTopologies(leftTopology)
            val rightSubtree = numberOfBinaryTreeTopologies(rightTopology)
            numberOfTopologies += leftSubtree * rightSubtree
        }

        return numberOfTopologies

    }

    // memoization
    fun numberOfBtTopology(n: Int): Int {
        if (n == 0)
            return 1

        val cache = mutableMapOf<Int, Int>()
        cache[0] = 1
        return getBinaryTopologyHelper(n, cache)

    }

    fun getBinaryTopologyHelper(n: Int, cache: MutableMap<Int, Int>): Int {

        if (n in cache) return cache[n]!!

        var numberOfTopologies = 0


        for (leftTopology in 0 until n) {
            val rightTopology = n - 1 - leftTopology
            val leftSubtree = getBinaryTopologyHelper(leftTopology, cache)
            val rightSubtree = getBinaryTopologyHelper(rightTopology, cache)
            numberOfTopologies += leftSubtree * rightSubtree
        }
        cache[n] = numberOfTopologies

        return numberOfTopologies

    }

// iterative
    fun numberOfBinaryTreeTopologies(n: Int): Int {
        if (n == 0) return 1

        val cache = mutableListOf<Int>(1)

        for (m in 1 until n + 1) {
            var numberOfTree = 0
            for (leftTreeSize in 0 until m) {
                val rightTreeSize = m - 1 - leftTreeSize
                val leftSubtree = cache[leftTreeSize]
                val rightSubtree = cache[rightTreeSize]
                numberOfTree += leftSubtree * rightSubtree
            }
            cache.add(numberOfTree)
        }

        return cache[n]
    }

}