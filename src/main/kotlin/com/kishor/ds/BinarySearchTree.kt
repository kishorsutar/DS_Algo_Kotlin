package com.kishor.ds

public class BinarySearchTree<T : Comparable<T>> {

    var root: Node<T>? = null
    var nodeCount = 0

    data class Node<T>(val data: T, var left: Node<T>? = null, var right: Node<T>? = null)

    fun isEmpty(): Boolean {
        return size() == 0
    }

    fun size(): Int {
        return nodeCount
    }

    fun add(elem: T): Boolean {
        return if (contains(elem)) { // add contains method
            false
        } else {
            root = root?.let { add(it, elem) }
            nodeCount++
            true
        }

    }

    fun add(node: Node<T>, elem: T): Node<T> {
        var nodeToReturn: Node<T>? = null
        if (node == null) {
            nodeToReturn = Node(elem, null, null)
        } else {

            if (elem.compareTo(node.data) < 0) {
                node.left = node.left?.let { add(it, elem) }
            } else {
                node.right = node.right?.let { add(it, elem) }
            }
        }

        return node
    }

}
