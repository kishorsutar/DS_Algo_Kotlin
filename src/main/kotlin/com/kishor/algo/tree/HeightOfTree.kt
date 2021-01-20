package com.kishor.algo.tree

import java.util.*
import kotlin.math.max

fun main() {
    val root = makeTree()
    println("Recursive ${getHeightOfTree(root)}")
    println("Iterative ${getHeightIteratively(root)}")
}

fun getHeightOfTree(node: BinaryTreeNode?): Int {
    if (node == null) return -1
    if (node.left == null && node.right == null) return 0
    return max(getHeightOfTree(node.left), getHeightOfTree(node.right)) + 1
}

fun getHeightIteratively(node: BinaryTreeNode?): Int {

    val queue = ArrayDeque<BinaryTreeNode>() // how define queue in Kotlin
    queue.offer(node)
    var height = -1
    while (queue.isNotEmpty()) {
        var size = queue.size

        height++

        while (size > 0) {
            val childNode = queue.remove()
            childNode.left?.let {
                queue.add(it)
            }
            childNode.right?.let {
                queue.add(it)
            }
            size--
        }
    }

    return height
}

private fun makeTree(): BinaryTreeNode? {
    val node0 = BinaryTreeNode(value = 0)
    val node1 = BinaryTreeNode(value = 1)
    val node2 = BinaryTreeNode(value = 2)
    node0.left = node1
    node0.right = node2
    val node3 = BinaryTreeNode(value = 3)
    val node4 = BinaryTreeNode(value = 4)
    node1.left = node3
    node1.right = node4
    val node5 = BinaryTreeNode(value = 5)
    val node6 = BinaryTreeNode(value = 6)
    node2.left = node5
    node2.right = node6
    val node7 = BinaryTreeNode(value = 7)
    val node8 = BinaryTreeNode(value = 8)
    node3.left = node7
    node3.right = node8
    return node0
}