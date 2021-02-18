package com.kishor.algo.algorithms.tree

import com.kishor.ds.BinarySearchTree

fun main() {
    // how to do tee representation
//    val bst = BinarySearchTree<Int>()
    var root = BinarySearchTree.Node(11)
    var rLeft = BinarySearchTree.Node(6)
    root.left = rLeft
    var rRight = BinarySearchTree.Node(15)
    root.right = rRight
    val node3 = BinarySearchTree.Node(3)
    rLeft.left = node3
    rLeft.right = BinarySearchTree.Node(8)
    val node1 = BinarySearchTree.Node(1)
    node3.left = node1
    val node5 = BinarySearchTree.Node(5)
    node3.right = node5
    val node13 = BinarySearchTree.Node(13)
    rRight.left = node13
    val node12 = BinarySearchTree.Node(12)
    node13.left = node12
    val node17 = BinarySearchTree.Node(17)
    node13.right = node17
    val node19 = BinarySearchTree.Node(19)
    node17.right = node19

//    bst.add(11)
//    bst.add(15)
//    bst.add(3)
//    bst.add(12)
//    bst.add(17)
//    bst.add(13)
//    bst.add(19)
//    bst.add(1)
//    bst.add(5)
//    bst.add(8)

    println(preOrderTraversalRecursive(root))
    println("------------------")
    println(postOrderTravRecursive(root))
    println("------------------")
    println(InOrderTraveRecursive(root))

}

//data class Node(var data: Int? = null, var left: Node? = null, var right: Node? = null)

fun preOrderTraversalRecursive(root: BinarySearchTree.Node<Int>?) {
    if (root == null) return

    println(root.data)
    preOrderTraversalRecursive(root.left)
    preOrderTraversalRecursive(root.right)
}

fun postOrderTravRecursive(root: BinarySearchTree.Node<Int>?) {
    if (root == null) return

    postOrderTravRecursive(root.left)
    postOrderTravRecursive(root.right)
    println(root.data)
}

fun InOrderTraveRecursive(root: BinarySearchTree.Node<Int>?) {
    if (root == null) return

    InOrderTraveRecursive(root.left)
    println(root.data)
    InOrderTraveRecursive(root.right)
}
