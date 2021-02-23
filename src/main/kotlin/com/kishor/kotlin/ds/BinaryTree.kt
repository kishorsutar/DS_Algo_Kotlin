package com.kishor.kotlin.ds

import java.util.*
import kotlin.math.abs
import kotlin.math.max

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

fun getBranchSum(node: BinaryTree, listOfSum: MutableList<Int>, runningSum: Int) {
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


fun invertRecursiveBinaryTree(tree: BinaryTree?) {
    if (tree == null) return
    swapLeftAndRight(tree)
    invertRecursiveBinaryTree(tree.left)
    invertRecursiveBinaryTree(tree.right)
}

fun swapLeftAndRight(node1: BinaryTree) {
    val left = node1.left
    node1.left = node1.right
    node1.right = left
}

fun invertIterativeBinaryTree(tree: BinaryTree) {
    val queue = ArrayDeque<BinaryTree>()
    queue.add(tree)
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        swapLeftAndRight(current)
        if (current.left != null) queue.add(current.left)
        if (current.right != null) queue.add(current.right)
    }
}

data class TreeInfo(val diameter: Int, val height: Int)

fun binaryTreeDiameter(tree: BinaryTree): Int {
    return getTreeInfo(tree).diameter
}

fun getTreeInfo(tree: BinaryTree?): TreeInfo {
    if (tree == null) return TreeInfo(0, 0)

    val leftTree = getTreeInfo(tree.left)
    val rightTree = getTreeInfo(tree.right)
    val longestPathThroughRoot = leftTree.height + rightTree.height
    val maxDiameterSoFar = max(leftTree.diameter, rightTree.diameter)
    val currentDiameter = max(longestPathThroughRoot, maxDiameterSoFar)
    val currentHeight = 1 + max(leftTree.height, rightTree.height)

    return TreeInfo(currentDiameter, currentHeight)
}

data class BinaryTreeWithParent(
    val value: Int, val left: BinaryTreeWithParent?,
    val right: BinaryTreeWithParent?,
    val parent: BinaryTreeWithParent?
)

fun findSuccessor(tree: BinaryTreeWithParent, node: BinaryTreeWithParent): BinaryTreeWithParent {

    if (node.right != null) return getLeftmostChild(node.right)

    return getRightmostParent(node)

}

fun getLeftmostChild(node: BinaryTreeWithParent): BinaryTreeWithParent {
    var currentNode = node

    while (currentNode.left == null) {
        currentNode = currentNode.left!!
    }

    return currentNode
}

fun getRightmostParent(node: BinaryTreeWithParent): BinaryTreeWithParent {
    var currentNode = node
    while (currentNode.parent != null && currentNode.parent!!.right == currentNode) {
        currentNode = currentNode.parent!!
    }

    return currentNode.parent!!
}

fun heightBalancedTree(tree: BinaryTree): Boolean {
    return getTreeBalanceInfo(tree).isBalanced
}

class TreeHeightInfo(height: Int, isBalanced: Boolean) {
    var height = height
    var isBalanced = isBalanced
}

fun getTreeBalanceInfo(node: BinaryTree?): TreeHeightInfo {

    if (node == null) return TreeHeightInfo(-1, true)

    val leftInfo = getTreeBalanceInfo(node.left)
    val rightInfo = getTreeBalanceInfo(node.right)

    val isBalanced = leftInfo.isBalanced && rightInfo.isBalanced && abs(leftInfo.height - rightInfo.height) <= 1

    val height = 1 + max(leftInfo.height, rightInfo.height)

    return TreeHeightInfo(height, isBalanced)
}




