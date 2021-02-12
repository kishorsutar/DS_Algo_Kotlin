package com.kishor.algo.algorithms.tree

fun main() {
    val rootNode = CustomTreeNode(5)
    val left = CustomTreeNode(4)
    val right = CustomTreeNode(3)
    rootNode.addChild(left)
    rootNode.addChild(right)

    val nodeOne = CustomTreeNode(1)
    left.addChild(nodeOne)
    val nodeSix = CustomTreeNode(-6)
    left.addChild(nodeSix)
    nodeOne.addChild(CustomTreeNode(2))
    nodeOne.addChild(CustomTreeNode(9))

    right.addChild(CustomTreeNode(0))
    val nodeSeven = CustomTreeNode(7)
    right.addChild(nodeSeven)
    right.addChild(CustomTreeNode(-4))
    nodeSeven.addChild(CustomTreeNode(8))

    println("Sum of leafs ${sumUpLeafNodeValues(rootNode)}")
}

fun sumUpLeafNodeValues(nodeCustom: CustomTreeNode): Int {
    if (nodeCustom == null) return 0
    if (nodeCustom.listOfChildren.size == 0) return nodeCustom.id
    var total = 0
    for (child in nodeCustom.listOfChildren) {
        total += sumUpLeafNodeValues(child)
    }
    return total
}