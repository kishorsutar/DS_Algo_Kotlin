package com.kishor.algo.tree

fun main() {
    val rootNode = TreeNode(5)
    val left = TreeNode(4)
    val right = TreeNode(3)
    rootNode.addChild(left)
    rootNode.addChild(right)

    val nodeOne = TreeNode(1)
    left.addChild(nodeOne)
    val nodeSix = TreeNode(-6)
    left.addChild(nodeSix)
    nodeOne.addChild(TreeNode(2))
    nodeOne.addChild(TreeNode(9))

    right.addChild(TreeNode(0))
    val nodeSeven = TreeNode(7)
    right.addChild(nodeSeven)
    right.addChild(TreeNode(-4))
    nodeSeven.addChild(TreeNode(8))

    println("Sum of leafs ${sumUpLeafNodeValues(rootNode)}")
}

fun sumUpLeafNodeValues(node: TreeNode): Int {
    if (node == null) return 0
    if (node.listOfChildren.size == 0) return node.rootId
    var total = 0
    for (child in node.listOfChildren) {
        total += sumUpLeafNodeValues(child)
    }
    return total
}