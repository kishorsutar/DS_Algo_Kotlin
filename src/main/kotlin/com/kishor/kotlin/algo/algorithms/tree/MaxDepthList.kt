package com.kishor.kotlin.algo.algorithms.tree

import java.util.*
import kotlin.math.max

fun main() {
    val five = Tree(5, listOf(Tree(1)))
    val six = Tree(6, listOf(Tree(7), Tree(8)))
    val twoChild = listOf(five)
    val two = Tree(2, twoChild)
    val rootChild = listOf(two, six, Tree(9))

    val root = Tree(4, rootChild)
    dfs(root)
}

data class Tree(val value: Int, val listOfChildren: List<Tree>? = null)


fun dfs(tree: Tree) {
    val stack = Stack<Pair<Tree, Int>>()

    stack.push(Pair(tree, 0))

    while (stack.isNotEmpty()) {
        val currentInfo = stack.pop()
        val currentNode = currentInfo.first
        var maxThusFar = currentInfo.second

        if (currentNode.listOfChildren == null) {
            println("node: ${currentNode.value} : max $maxThusFar")
        } else {
            for (child in currentNode.listOfChildren) {
                maxThusFar = max(child.value, maxThusFar)
                stack.push(Pair(child, maxThusFar))
            }
        }
    }
}