package com.kishor.kotlin.algo.algorithms.graph

class SingleCycleCheck {

    fun hasSingleCycle(array: List<Int>): Boolean {
        var numElementVisited = 0
        var currentIdx = 0
        while (numElementVisited < array.size) {
            if (numElementVisited > 0 && currentIdx == 0) return false
            numElementVisited++
            currentIdx = getNextIdx(currentIdx, array)
        }

        return currentIdx == 0
    }

    fun getNextIdx(currentIdx: Int, array: List<Int>) : Int {
        val jump = array[currentIdx]
        val nextIdx = (currentIdx + jump) % array.size // for values out of bound
        return if (nextIdx >= 0) nextIdx else nextIdx + array.size

    }

}