package com.kishor.kotlin.algo.problems.arrayandstrings

import java.util.*
import kotlin.collections.ArrayList


fun main() {
//    groupAnagrams()
    println("${groupAnagrams(arrayOf( "eat", "tea", "tan", "ate", "nat", "bat"))}")
//    groupAnagramsTes(arrayOf( "eat", "tea", "tan", "ate", "nat", "bat"))
}

/*fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val answerList = ArrayList<ArrayList<String>>()
    for (i in strs.indices) {
        val innerList = ArrayList<String>()
        innerList.add(strs[i])
        for (j in i until strs.size) {
            if (isAnagram(strs[i], strs[j])) {
                innerList.add(strs[j])
            }
        }
        answerList.add(innerList)
    }
    return answerList
}*/

fun isAnagram(str1: String, str2: String): Boolean {
    val intArray1 = IntArray(26) {0}
    for (c in str1) {
        intArray1[c.toInt() - 96] = 1
    }

    for (c in str2) {
        intArray1[c.toInt() - 96] = 0
    }

    for (i in intArray1) {
        if (i == 1) {
            return false
        }
    }

    return true
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val mapOfAnagrams = HashMap<String, MutableList<String>>()
    for (str in strs) {
        val ca = str.toCharArray()
        Arrays.sort(ca)
        val key = String(ca)
        if (!mapOfAnagrams.containsKey(key))
            mapOfAnagrams[key] = ArrayList<String>()

        mapOfAnagrams[key]?.add(str)
    }

    return ArrayList(mapOfAnagrams.values)

}