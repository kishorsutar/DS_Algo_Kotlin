package com.kishor.kotlin.algo.algorithms.tree

data class CustomTreeNode(
    val id: Int = 0,
    val parent: CustomTreeNode? = null,
    val listOfChildren: MutableList<CustomTreeNode> = mutableListOf()
) {
    fun getChildren(): List<CustomTreeNode> {
        return listOfChildren
    }

    fun addChild(nodeCustom: CustomTreeNode) {
        listOfChildren.add(nodeCustom)
    }
}