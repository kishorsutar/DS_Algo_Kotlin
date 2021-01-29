package com.kishor.algo

fun main() {
    val quickSelect = QuickSelect(arrayOf(2, 4, 7, -1, 0, 9))
    println("the kth smallest ${quickSelect.select(3)}")
}
class QuickSelect(val nums: Array<Int>) {

    // selection phase
    // quickSelect//
// pivot = // partition
// swap

    fun select(k: Int): Int  {
        return quickSelect(0, nums.size - 1, k - 1)
    }

    private fun quickSelect(firstIndex: Int, lastIndex: Int, k: Int): Int {
        val pivotIndex = partitionSmallest(firstIndex, lastIndex)

        if (pivotIndex < k) {
            return quickSelect(pivotIndex + 1, lastIndex, k)
        }
        else if (pivotIndex > k) {
            return quickSelect(firstIndex, pivotIndex - 1, k)
        }
        return nums[pivotIndex]
    }

    private fun partitionSmallest(firstIndex: Int, lastIndex: Int): Int {
        var first = firstIndex
        val pivot = (first..lastIndex).shuffled().first()

        swap(pivot, lastIndex)

        for (i in nums.indices) {
            if (nums[i] < nums[lastIndex]) {
                swap(first, i)
                first++
            }
        }

        swap(first, lastIndex)

        return first
    }

    private fun partitionLargest(firstIndex: Int, lastIndex: Int): Int {
        var first = firstIndex
        val pivot = (first..lastIndex).shuffled().first()

        swap(pivot, lastIndex)

        for (i in nums.indices - 1) {
            if (nums[i] > nums[lastIndex]) {
                swap(first, i)
                first++
            }
        }

        swap(first, lastIndex)

        return first
    }


    private fun swap(one: Int, other: Int) {
        val temp = nums[one]
        nums[one] = nums[other]
        nums[other] = temp
    }
}
