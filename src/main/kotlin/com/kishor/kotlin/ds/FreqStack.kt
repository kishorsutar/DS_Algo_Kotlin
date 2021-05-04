package com.kishor.kotlin.ds

import java.util.Stack

var freq: MutableMap<Int?, Int?> = mutableMapOf()
var group: MutableMap<Int?, Stack<Int>> = mutableMapOf()
var maxfreq = 0


fun push(x: Int) {
    val f = freq.getOrDefault(x, 0)!! + 1
    freq[x] = f
    if (f > maxfreq) maxfreq = f
    group.computeIfAbsent(
        f
    ) { z: Int? -> Stack<Int>() }.push(x)
}

fun pop(): Int {
    val x = group!![maxfreq]!!.pop()!!
    freq!![x] = freq!![x]!! - 1
    if (group!![maxfreq]!!.size == 0) maxfreq--
    return x
}