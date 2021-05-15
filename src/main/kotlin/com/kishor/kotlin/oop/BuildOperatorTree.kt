package com.kishor.kotlin.oop

import java.util.Stack


internal abstract class Node {
    abstract fun evaluate(): Int

    // define your fields here
    var left: Node? = null
    var right: Node? = null
    var `val`: String? = null
}

internal class NumericNode(`val`: String?) : Node() {
    override fun evaluate(): Int {
        return `val`!!.toInt()
    }

    init {
        this.`val` = `val`
        left = null
        right = null
    }
}


internal class OperatorNode(`val`: String?) : Node() {
    override fun evaluate(): Int {
        return performOperation(`val`!!, left!!.evaluate(), right!!.evaluate())
    }

    private fun performOperation(opert: String, a: Int, b: Int): Int {
        val operator = opert[0]
        return if (operator == '*') {
            a * b
        } else if (operator == '+') {
            a + b
        } else if (operator == '-') {
            a - b
        } else {
            a / b
        }
    }

    init {
        this.`val` = `val`
    }
}

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */
internal class TreeBuilder {
    var inputString = mutableListOf<String>()
    fun buildTree(postfix: Array<String>): Node? {
        val stack: Stack<Node?> = Stack<Node?>()
        for (item in postfix) {
            if (isOperator(item)) {
                val right = stack.pop()
                val left = stack.pop()
                val node: Node = OperatorNode(item)
                node.left = left
                node.right = right
                stack.push(node)
            } else {
                stack.push(NumericNode(item))
            }
        }
        return stack.pop()
    }

    private fun isOperator(str: String): Boolean {
        val ch = str[0]
        return ch == '+' || ch == '-' || ch == '*' || ch == '/'
    }
}