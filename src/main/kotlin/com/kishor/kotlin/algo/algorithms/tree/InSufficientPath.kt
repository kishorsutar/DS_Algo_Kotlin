package com.kishor.kotlin.algo.algorithms.tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

    fun sufficientSubset(root: TreeNode, limit: Int): TreeNode? {
        calculate(root, limit, 0)
        return if (root.`val` < limit && root.left == null && root.right == null) null else root
    }

    fun calculate(root: TreeNode?, limit: Int, sum: Int): Boolean {
        var sum = sum
        if (root == null) return true
        if (sum + root.`val` < limit && root.left == null && root.right == null) return true
        if (sum + root.`val` >= limit && root.left == null && root.right == null) return false
        sum = sum + root.`val`
        val left = calculate(root.left, limit, sum)
        val right = calculate(root.right, limit, sum)
        if (left) {
            root.left = null
        }
        if (right) {
            root.right = null
        }
        return left && right
    }

fun singleNonDuplicate(nums: IntArray): Int {
    var lo = 0
    var hi = nums.size - 1
    while (lo < hi) {
        val mid = lo + (hi - lo) / 2
        val halvesAreEven = (hi - mid) % 2 == 0
        if (nums[mid + 1] == nums[mid]) {
            if (halvesAreEven) {
                lo = mid + 2
            } else {
                hi = mid - 1
            }
        } else if (nums[mid - 1] == nums[mid]) {
            if (halvesAreEven) {
                hi = mid - 2
            } else {
                lo = mid + 1
            }
        } else {
            return nums[mid]
        }
    }
    return nums[lo]
}