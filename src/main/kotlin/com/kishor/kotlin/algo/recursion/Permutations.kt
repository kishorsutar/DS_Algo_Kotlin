package com.kishor.kotlin.algo.recursion


// Time: O(n^2 n!)
// Space: O(n.n!)
fun getPermutaion(array: List<Int>): List<List<Int>> {

    val permutations = mutableListOf<List<Int>>()
    helper(array, listOf<Int>(), permutations)
    return permutations
}

fun helper(array: List<Int>, currentPermutations: List<Int>, permutations: MutableList<List<Int>>) {
    if (array.size == 0 && currentPermutations.size > 0) {
        permutations.add(currentPermutations)
        return
    }

    for (element in array) {
        val newArray = array.toMutableList()
        newArray.remove(element)
        val newPermutation = currentPermutations.toMutableList()
        newPermutation.add(element)
        helper(newArray, newPermutation, permutations)

    }
}
