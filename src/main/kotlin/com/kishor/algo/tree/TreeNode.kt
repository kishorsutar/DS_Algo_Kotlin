package com.kishor.algo.tree

class TreeNode(
    val rootId: Int = 0,
    val parent: TreeNode? = null,
    val listOfChildren: MutableList<TreeNode> = mutableListOf()
) {
    fun getChildren(): List<TreeNode> {
        return listOfChildren
    }

    fun addChild(node: TreeNode) {
        listOfChildren.add(node)
    }
}