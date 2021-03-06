package com.kishor.kotlin.algo.algorithms.graph

import java.util.*

class RemoveIslands {


    fun removeIsland(matrix: List<MutableList<Int>>): List<MutableList<Int>> {

        for (row in 0 until matrix.size) {
            val rowBorder = row == 0 || row == matrix.size - 1

            for (col in 0 until matrix[row].size) {
                val colBorder = col == 0 || col == matrix[row].size - 1
                val isBorder = rowBorder || colBorder

                if (!isBorder) continue
                if (matrix[row][col] != 1) continue

                dfsAndMarkTwo(matrix, Pair(row, col))
            }
        }

        for (row in 0 until matrix.size) {
            for (col in 0 until matrix[row].size) {
                if (matrix[row][col] > 0) {
                    matrix[row][col] -= 1
                }
            }
        }

        return matrix
    }

    fun dfsAndMarkTwo(matrix: List<MutableList<Int>>, position: Pair<Int, Int>) {

        val stack = Stack<Pair<Int, Int>>()
        stack.push(position)

        while (stack.isNotEmpty()) {
            val currentPosition = stack.pop()
            val (currentRow, currentCol) = currentPosition

            matrix[currentRow][currentCol] = 2

            val itemsNeighbourList = getItemNeighbour(matrix, currentPosition)
            for (neighbour in itemsNeighbourList)	{
                val (row, col) = neighbour
                if (matrix[row][col] != 1) continue
                stack.add(Pair(row, col))
            }
        }
    }

    fun getItemNeighbour(matrix: List<MutableList<Int>>, item: Pair<Int, Int>): List<Pair<Int, Int>> {

        val neighbours = mutableListOf<Pair<Int, Int>>()
        val (row, col) = item
        val numRows = matrix.size
        val numCols = matrix[row].size

        if (row - 1 >= 0) neighbours.add(Pair(row - 1, col))
        if (row + 1 < numRows) neighbours.add(Pair(row + 1, col))
        if (col - 1 >= 0) neighbours.add(Pair(row, col - 1))
        if (col + 1 < numCols) neighbours.add(Pair(row, col + 1))

        return neighbours
    }

}