package com.kishor.ds

import java.util.*

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

fun branchSums(root: BinaryTree): List<Int> {
    val listOfSum = mutableListOf<Int>()
    getBranchSum(root, listOfSum, 0)
    return listOfSum
}

fun getBranchSum(node: BinaryTree, listOfSum: MutableList<Int>, runningSum: Int){
    var currentSum = runningSum

    if (node.left == null && node.right == null) {
        currentSum += node.value
        listOfSum.add(currentSum)
        return
    } else {
        currentSum += node.value
    }

    if (node.left != null) {
        getBranchSum(node.left!!, listOfSum, currentSum)
    }
    if (node.right != null) {
        getBranchSum(node.right!!, listOfSum, currentSum)
    }
}

fun nodeDepthsRecursive(root: BinaryTree): Int {
    var runningSum = 0

    return depthSum(root, runningSum)
}

fun depthSum(node: BinaryTree?, runningSum: Int): Int {

    if (node == null) return 0

    return runningSum + depthSum(node.right, runningSum) + depthSum(node.left, runningSum)

}

class Level(tree: BinaryTree, depth: Int) {
    var depth = depth
    var tree = tree
}

fun nodeDepthIterative(root: BinaryTree): Int {
    val stack = Stack<Level>()
    var sumOfDepth = 0


    stack.push(Level(root, 0))

    while (stack.isNotEmpty()) {

        val top = stack.pop()
        val node = top.tree
        val depth = top.depth
        sumOfDepth += depth
        if (node.left != null) {
            stack.push(Level(node.left!!, depth + 1))
        }

        if (node.right != null) {
            stack.push(Level(node.right!!, depth + 1))
        }
    }

    return sumOfDepth
}


fun nodeDepthLevelIterative(root: BinaryTree): Int {
    val queue = ArrayDeque<Level>()
    var sumOfDepth = 0


    queue.add(Level(root, 0))

    while (queue.isNotEmpty()) {

        val top = queue.poll()
        val node = top.tree
        val depth = top.depth
        sumOfDepth += depth
        if (node.left != null) {
            queue.add(Level(node.left!!, depth + 1))
        }

        if (node.right != null) {
            queue.add(Level(node.right!!, depth + 1))
        }
    }

    return sumOfDepth
}

