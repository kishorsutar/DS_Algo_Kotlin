package com.kishor.ds

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