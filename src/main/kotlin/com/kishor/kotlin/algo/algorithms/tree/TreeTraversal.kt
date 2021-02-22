package com.kishor.kotlin.algo.algorithms.tree

import com.kishor.kotlin.ds.BinarySearchTree
import java.util.*

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
    rRight.right = node17
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
    println("---------Pre---------")
    println(preOrderTraversalRecursive(root))
    println("---------Pre---------")
    println(preOrderIterative(root))
    println("--------Post----------")
    println(postOrderTravRecursive(root))
    println("--------Post----------")
//    println(postOrderIterative(root))
//    println("---------In---------")
//    println(InOrderTraveRecursive(root))
//    println("---------Level---------")
//    println(levelOrderTraversalIterative(root))

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

fun levelOrderTraversalIterative(root: BinarySearchTree.Node<Int>?) {
    if (root == null) return

    val queue = ArrayDeque<BinarySearchTree.Node<Int>>()

    queue.add(root)

    while (queue.isNotEmpty()) {
        val node = queue.poll()

        println(node.data)
        if (node.left != null) {
            queue.add(node.left)
        }
        if(node.right != null)
            queue.add(node.right)
    }
}

fun preOrderIterative(root: BinarySearchTree.Node<Int>) {
    val stack = Stack<BinarySearchTree.Node<Int>>()
    stack.push(root)

    while (stack.isNotEmpty()) {
        val node = stack.pop()
        println(node.data)
        if (node.right != null)
            stack.push(node.right)
        if (node.left != null)
            stack.push(node.left)
    }
}
// TODO: Morris traversal algorithm
//fun postOrderIterative(root: BinarySearchTree.Node<Int>) {
//    val stack = Stack<BinarySearchTree.Node<Int>>()
//    while (stack.isNotEmpty()) {
//        val node = stack.pop()
//        if (node.right != null)
//            stack.push(node.right)
//        if (node.left != null)
//            stack.push(node.left)
//
//        println(node.data)
//    }
//}


