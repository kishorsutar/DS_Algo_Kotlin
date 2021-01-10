package com.kishor.algo.tree

import com.kishor.algo.algorithms.graph.AdjacencyMatrixWeightedGraph

fun main() {
    rootATree(AdjacencyMatrixWeightedGraph(0))
}

fun rootATree(graph: AdjacencyMatrixWeightedGraph, rootId: Int = 0): TreeNode {

    val root = TreeNode(rootId, null, mutableListOf())

    return buildTree(graph, root, null)

}

fun buildTree(graph: AdjacencyMatrixWeightedGraph, node: TreeNode, parent: TreeNode?): TreeNode {
    for (childId in graph.matrix[node.rootId]) {
        if (parent != null && childId == parent.rootId) {
            continue
        }
        val child = TreeNode(childId, node, arrayListOf()) // arraylist of ? // inline function
        node.listOfChildren.add(child)
        buildTree(graph, child, node)
    }
    return node
}
