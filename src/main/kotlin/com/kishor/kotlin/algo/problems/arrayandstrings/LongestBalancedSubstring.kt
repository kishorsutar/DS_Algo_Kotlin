package com.kishor.kotlin.algo.problems.arrayandstrings

import java.util.*
import kotlin.math.max

class LongestBalancedSubstring {
    // O(n^3)
    fun longestBalancedSubstringNaive(string: String): Int {
        var maxLength = 0

        for (i in 0 until string.length) {
            for (j in i + 2 until string.length + 1 step 2) {
                if (isBalanced(string.substring(i, j))) {
                    val currentLength = j - i
                    maxLength = max(maxLength, currentLength)
                }
            }
        }
        return maxLength
    }

    fun isBalanced(string: String): Boolean {
        val stack = Stack<Char>()

        for(c in string.toCharArray()) {
            if (c == '(') {
                stack.push(c)
            } else if (stack.isNotEmpty()) {
                stack.pop()
            } else {
                return false
            }
        }

        return stack.isEmpty()
    }

// O(n) O(n)
    fun longestBalancedSubstringWithIndexedStack(string: String): Int {

        val indexedStack = Stack<Int>()
        indexedStack.push(-1)

        var currentLength = 0
        var maxLength = 0

        for (i in 0 until string.length) {
            if (string[i] == ')') {
                indexedStack.pop()

                if (indexedStack.isEmpty()) {
                    indexedStack.push(i)
                } else {
                    val balancedSubstringIndex = indexedStack[indexedStack.size - 1]
                    val currentLength = i - balancedSubstringIndex
                    maxLength = max(currentLength, maxLength)
                }
            } else {
                indexedStack.push(i)

            }
        }

        return maxLength

    }

    // O(n) O(1)
    fun longestBalancedSubstringConstSpace(string: String): Int {
        var openingCount = 0
        var closingCount = 0
        var currentLength = 0
        var maxLength = 0

        for (c in string) {

            if (c == ')') {
                closingCount++
            } else {
                openingCount++
            }

            if (openingCount == closingCount) {
                currentLength = 2 * closingCount
                maxLength = max(currentLength, maxLength)
            } else if (closingCount > openingCount) {
                openingCount = 0
                closingCount = 0
                currentLength = 0
            }

        }

        openingCount = 0
        closingCount = 0
        currentLength = 0


        for (char in string.toCharArray().size - 1 downTo 0) {
            val c = string[char]
            if (c == '(') {
                openingCount++
            } else {
                closingCount++
            }

            if (openingCount == closingCount) {
                currentLength = 2 * closingCount
                maxLength = max(currentLength, maxLength)
            } else if (openingCount > closingCount) {
                openingCount = 0
                closingCount = 0
                currentLength = 0
            }

        }

        return maxLength
    }



}