package com.kishor.algo.tree

data class TreeNode(
    val rootId: Int = 0,
    val parent: TreeNode? = null,
    val listOfChildren: MutableList<TreeNode> = mutableListOf()
)