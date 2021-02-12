package com.kishor.algo.algorithms.tree

import com.kishor.algo.algorithms.graph.AdjacencyMatrixWeightedGraph

fun main() {
    rootATree(AdjacencyMatrixWeightedGraph(0))
}

fun rootATree(graph: AdjacencyMatrixWeightedGraph, rootId: Int = 0): CustomTreeNode {

    val root = CustomTreeNode(rootId, null, mutableListOf())

    return buildTree(graph, root, null)

}

//fun buildTree(graph: AdjacencyMatrixWeightedGraph, nodeCustom: CustomTreeNode, parent: CustomTreeNode?): CustomTreeNode {
//    for (childId in graph.matrix[nodeCustom.id]) {
//        if (parent != null && childId == parent.id) {
//            continue
//        }
//        val child = CustomTreeNode(childId, nodeCustom, arrayListOf()) // arraylist of ? // inline function
//        nodeCustom.listOfChildren.add(child)
//        buildTree(graph, child, nodeCustom)
//    }
//    return nodeCustom
//}




fun rootingATree(g: AdjacencyMatrixWeightedGraph, rootId: Int): CustomTreeNode  {
    val root = CustomTreeNode(rootId,null, mutableListOf<CustomTreeNode>())
    return buildTree(g, null, root)
}

fun buildTree(g: AdjacencyMatrixWeightedGraph, parent: CustomTreeNode?, nodeCustom: CustomTreeNode?): CustomTreeNode {
    for (childId in g.matrix[nodeCustom!!.id]) {
        if (parent != null && childId == parent.id)
            continue
        val child = CustomTreeNode(childId, nodeCustom, mutableListOf<CustomTreeNode>())
        nodeCustom.listOfChildren.add(child)
        buildTree(g, nodeCustom, child)
    }
    return nodeCustom
}

