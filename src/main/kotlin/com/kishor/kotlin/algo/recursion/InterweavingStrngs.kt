package com.kishor.kotlin.algo.recursion

fun interweavingStrings(one: String, two: String, three: String): Boolean {
    if (three.length != one.length + two.length) {
        return false
    }
    val cache = List(one.length + 1, { MutableList<Boolean?>(two.length + 1, { null }) })
    return areInterwoven(one, two, three, 0, 0, cache)
}

fun areInterwoven(one: String, two: String, three: String, i: Int, j: Int, cache: List<MutableList<Boolean?>>): Boolean {
    if (cache[i][j] != null) return cache[i][j]!!

    val k = i + j
    if (k == three.length) return true

    if (i < one.length && one[i] == three[k]) {
        cache[i][j] = areInterwoven(one, two, three, i + 1, j, cache)
        if (cache[i][j]!!) return true
    }

    if (j < two.length && two[j] == three[k]) {
        cache[i][j] = areInterwoven(one, two, three, i, j + 1, cache)
        return cache[i][j]!!
    }

    cache[i][j] = false
    return false

}