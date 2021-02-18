package com.kishor.ds

class BinarySearchTree<T : Comparable<T>> {

    var root: Node<T>? = null
    var nodeCount = 0

    data class Node<T>(var data: T, var left: Node<T>? = null, var right: Node<T>? = null)

    fun isEmpty(): Boolean {
        return size() == 0
    }

    fun size(): Int {
        return nodeCount
    }

    fun add(elem: T): Boolean {
        return if (contains(root, elem)) { // add contains method
            false
        } else {
            root = root?.let { add(it, elem) }
            nodeCount++
            true
        }

    }

    fun add(node: Node<T>, elem: T): Node<T>? {
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

        return nodeToReturn
    }

    // private recursive method to find an element in the tree
    private fun contains(node: Node<T>?, elem: T): Boolean {

        // Base case: reached bottom, value not found
        if (node == null) return false
        val cmp = elem.compareTo(node.data)

        // Dig into the left subtree because the value we're
        // looking for is smaller than the current value
        return if (cmp < 0) contains(node.left, elem) else if (cmp > 0) contains(node.right, elem) else true
    }

    /**
    find the element if it's exists
    - apply technique if it's leaf node is removed. -> check if left and right is null
    - if it has only left child - get the successor and add replace it with current node-> righis null
    - if it has only right childe - get the right successor and replace with current -> left is null
    - if it has both then go to smallest on right or largest on left and make the successor  - take left first

     */
    fun removeElement(elem: T): Boolean {
        if (contains(root, elem)) {
            root = remove(elem, root)
            nodeCount--
            return true
        }

        return false
    }


    fun remove(elem: T, node: Node<T>?): Node<T>? {
        if (node == null) return null

        val cmp = elem.compareTo(node.data)

        if (cmp < 0) {
            node.left = remove(elem, node.left)
        } else if (cmp > 0) {
            node.right = remove(elem, node.right)
        } else {
            if (node.left == null) {
                return node.right
            } else if (node.right == null) {
                return node.left
            } else {

                val temp = findMin(node.right!!)

                node.data = temp!!.data

                node.right = remove(temp.data, node.right)
            }
        }
        return node
    }

    fun findMin(node: Node<T>): Node<T>? {
        var temp: Node<T>? = node
        while (node.left == null) temp = node.left
        return temp
    }
}
