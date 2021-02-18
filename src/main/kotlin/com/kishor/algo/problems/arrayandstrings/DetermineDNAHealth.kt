package com.kishor.algo.problems.arrayandstrings

import java.util.*

fun main(args: Array<String>) {
//    val scan = Scanner(System.`in`)
//
//    val n = scan.nextLine().trim().toInt()
//
//    val genes = scan.nextLine().split(" ").toTypedArray()
//
//    val health = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
//
//    val s = scan.nextLine().trim().toInt()
//
//    val healthList = mutableListOf<Int>()
//    for (sItr in 1..s) {
//        val firstLastd = scan.nextLine().split(" ")
//
//        val first = firstLastd[0].trim().toInt()
//
//        val last = firstLastd[1].trim().toInt()
//
//        val d = firstLastd[2]
//
//        healthList.add(findHealthyDna(first, last, d, genes, health))
//    }
//
//    healthList.sort()
//    println("${healthList[0]} ${healthList[healthList.size-1]}" )

    val list = getInputStrCombinationList("caaab")
    println(list.toString())
}

fun findHealthyDna(first: Int, last: Int, d: String, genes: Array<String>, health: Array<Int>): Int {
    /**
    - Get list of all the combinations of input string d
    - in the array look from first to last if any of the combination is present
    - once we get the index of it, get the respective value from health array
    - add to the sum
    - add sum to the list
     */

    val inputStrCombinationList = getInputStrCombinationList(d) // List<String>
    var sum = 0
    for (combGene in inputStrCombinationList) {
        for (i in first..last+1) {
            if (genes[i] == combGene) {
                sum += health[i]
                println("$combGene and ${genes[i]} sum is $sum")
            }
        }
    }
    return sum
}

fun getInputStrCombinationList(d: String): List<String> {
    val combList = mutableListOf<String>()
    for (i in d.indices) {
        for (j in i+1 until d.length) {
            combList.add(d.substring(i, j+1))
        }
    }
    println(combList.toString())
    return combList
}
