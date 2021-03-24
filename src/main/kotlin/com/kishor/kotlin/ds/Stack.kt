package com.kishor.kotlin.ds

import java.util.*

fun sunsetViews(buildings: List<Int>, direction: String): List<Int> {

    if (buildings.size == 0) return emptyList()
    if (buildings.size == 1) return listOf(0)

    if (direction == "EAST") {
        return getEastDirectedBuildings(buildings)
    } else {
        return getWestDirectedBuildings(buildings)
    }
}

fun getEastDirectedBuildings(buildings: List<Int>): List<Int> {
    val sunSetViewFor = Stack<Int>()
    sunSetViewFor.push(buildings.size - 1)
    for (i in buildings.size - 2 downTo 0) {
        if (buildings[i] > sunSetViewFor.peek()) {
            sunSetViewFor.push(i)
        }
    }

    return sunSetViewFor.toList()
}

fun getWestDirectedBuildings(buildings: List<Int>): List<Int> {
    val sunSetViewFor = ArrayDeque<Int>()
    sunSetViewFor.add(0)
    for (i in 1 until buildings.size) {
        if (sunSetViewFor.last < buildings[i]) {
            sunSetViewFor.add(i)
        }
    }

    return sunSetViewFor.toMutableList()
}