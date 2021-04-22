package com.kishor.kotlin.algo.algorithms.tree
class Node(var `val`: Int) {
        var left: Node? = null
         var right: Node? = null
         var next: Node? = null
     }

internal class Solution {
    fun connect(root: Node?): Node? {
        if (root == null) {
            return root
        }

        // Start with the root node. There are no next pointers
        // that need to be set up on the first level
        var leftmost: Node = root

        // Once we reach the final level, we are done
        while (leftmost.left != null) {

            // Iterate the "linked list" starting from the head
            // node and using the next pointers, establish the
            // corresponding links for the next level
            var head: Node? = leftmost
            while (head != null) {

                // CONNECTION 1
                head.left?.next = head.right

                // CONNECTION 2
                if (head.next != null) {
                    head.right?.next = head.next?.left
                }

                // Progress along the list (nodes on the current level)
                head = head.next
            }

            // Move onto the next level
            leftmost = leftmost.left!!
        }
        return root
    }
}