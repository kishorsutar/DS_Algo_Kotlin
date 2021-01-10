package com.kishor.ds

import java.util.*

fun main() {
//    allNumbers()
//
//    declarationOfString()
//
//    stringInterpolation()
//
//    boolean()
//
//    creatingArrays()

//    mutableListFunction()

//    flattenListAndArray()

//    combiningMutableList()

//    mapOperations()

//    kotlinSetStructure()
//    creatingHashMap()
//    creatingMutableHashMap()
//    filteringAndTransformingMap()
    stackUsage()
}


private fun declerationOfString() {
    // string and characters

    var fullName = "Kishor Sutar"

    val fulChar = 'x'

    val c: Char = 'f' // 16 bit unicode character less memory compared to String, so for single character use char.
}

private fun allNumbers() {
    // All generates from Number class
    val byte: Byte = 8 // 8-bit signed integer
    val myShort: Short = 16 // 16-bit signed integer
    val myInt: Int = 32 // 32-bit signed integer
    val myLong: Long = 64 // 64-bit signed integer

    // decimals
    val myFloat: Float = 32.00F // 32-bit floating point number
    val myDouble: Double = 64.00 // 64-bit floating point number

    val bigLong: Long = 1_000_000_000

    println(myInt.toLong()::class)
    val newInt = myInt.plus(12)
    println(bigLong)
    println(newInt)
}

fun stringInterpolation() {
    val uglyWay: String = "Hello, \nMy Name is Kishor, \nHow are you?"
    println(uglyWay)

    val newWay = """ 
        Hello
        My name is Kishor
        How are you?
    """.replaceIndent("->")
    println(newWay)

    println("${uglyWay.length} and this can concatenate")
}

fun boolean() {
    var isChecked: Boolean = false
    println("\n Boolean")
    println(isChecked)
    //inverting
    println(isChecked.not())
    println(!isChecked)
}

fun creatingArrays() {
    val intArray = IntArray(4) { i ->
        i * i
    }

    val items = arrayOf(1, 2, 3, 5, 6)
    val itemsString = arrayOf("Kishor", "Rupali", "Test", "London", "Europe")

    for (i in items) {
        if (i == 8) break
        else continue
    }
    items.forEach {
        if (it == 8) {
            println("vallue insode condition")
        }
    }

    itemsString.forEach { str ->
        if (str.contains('e')) {
            println("$str is valid")
        }
    }

    for (i in 0 until itemsString.size - 1) {
        val str = itemsString[i]
        if (str.contains('e')) {
            println("$str is valid with index $i")
        }
    }


    // does not modify current array.. adds and returns a new object
    val newArrayWithValue = itemsString.plus(arrayOf("james bond", "Captain America"))

    for (element in itemsString) {
        println(element)
    }

    newArrayWithValue.forEach {
        println(" lambda $it")
    }

    itemsString[0] = "Harry Potter"

    itemsString[2] = "test"
}

fun immutabelList() {
    val list = listOf("Kishor", "Rupali", "Test", "London", "Europe")

    list.first()
    list.last()

    val name: String? = null
    val test = if (name == null) emptyList() else listOf("Test")

    // finding item
    val first = list.firstOrNull { it == "London" }
    val indexOfFist = list.indexOfFirst { it == "Rupali" }
    val indexOfElement = list.indexOf("James")

    //filter
    list.filter { it.contains('k') }
    list.filterNot { it.contains('k') }

}

fun mutableListFunction() {
//    val list = mutableListOf("Kishor Sutar", "Google", "Techie")
    val list = mutableListOf<String>()
    list.add("London")
    list.add(0, "Rupali")
//    list.set(3, "Rupali")
    list[3] = "Rupali"

    list.forEach { println(it) }

    // filtering a list in kotlin
    val filterList = listOf("Kishor", "John", "Donn", "James")
//    val newFilterList = filterList.filter { it.toLowerCase().contains('o') }
    val newFilterList = filterList.filter(predicate = { it.toLowerCase().contains('o') })
    println(newFilterList)

    // filter to new list
    filterList.filterTo(list, {
        it == "John"
    })
}


fun flattenListAndArray() {
    val listName = listOf("Kishor", "Rupali", "Manya", "Snehal", "Omkya")
    val listPlace = listOf("London", "London", "Pune", "Amsterdam", "Seattle")
    val listOccupation = listOf("Soft Eng", "FullStack", "Designer", "Analyst", "Devops")
    val allListCombined = listOf(listName, listOccupation, listPlace)

    println(allListCombined)
    println(allListCombined.flatten())

    val arrayName = arrayOf("Kishor", "Rupali", "Manya", "Snehal", "Omkya")
    val arrayPlace = arrayOf("London", "London", "Pune", "Amsterdam", "Seattle")
    val arrayOccupation = arrayOf("Soft Eng", "FullStack", "Designer", "Analyst", "Devops")
    val allArrayCombined = arrayOf(arrayName, arrayPlace, arrayOccupation)

    println(allArrayCombined)
    println(allArrayCombined.flatten())
}

fun combiningMutableList() {
    val listName = listOf("Kishor", "Rupali", "Manya", "Snehal", "Omkya")
    val listPlace = listOf("London", "London", "Pune", "Amsterdam", "Seattle")
    val listOccupation = listOf("Soft Eng", "FullStack", "Designer", "Analyst", "Devops")

    val allTogether = listName.plus(listPlace).plus(listOccupation)
    println(allTogether)

    val minusSomeData = allTogether.minus("Kishor")
    val minusSomeList = allTogether.minus(listOccupation)
    println(allTogether)
    println(minusSomeData)
    println(minusSomeList)
}

fun mapOperations() {
    val listName = listOf(
        Occupation(listOf("kishor", "Rupali", "Manya", "Snehal", "Omkya")),
        Occupation(listOf("London", "London", "Pune", "Amsterdam", "Seattle"))
    )

//    val firstMap = listName.map {
//        val updatedList = mutableListOf<String>()
//        if (it.length == 5) {
//            updatedList.add(it)
//        }
//        updatedList
//    }
//    firstMap.map {
//        if (it.size > 0)
//            it.forEach { println(it) }
//
//    }

    val personMap = listName.map { it.items }

    println(personMap)

    val personFlatMap = listName.flatMap { it.items }
    println(personFlatMap)
}

class Occupation(val items: List<String>)

fun kotlinSetStructure() {
    val set = setOf("Kishor", "Rupali", "Manya", "Snehal", "Omkya", "Kishor", "Manya")
    println(set)

    val mutableSet = mutableSetOf<String>()
    println(mutableSet)

    mutableSet.add("Kishor")
    mutableSet.add("Manya")
    mutableSet.add("Random name")

    println(mutableSet)

    val mutableSetOfPerson = mutableSetOf(
        Person("Kishor"),  // with data class single object, only class creates new object with
        //new hashcode
        Person("Kishor")
    )

    println(mutableSetOfPerson)

}

fun creatingHashMap() {
    val mapOfAvengers = mapOf<String, String>(
        "IM" to "Iron Man",
        "CA" to "Captain America",
        "TH" to "Thor",
        "HK" to "Hulk"
    )

    mapOfAvengers.asSequence()
    mapOfAvengers.containsKey("IM") // true
    mapOfAvengers.containsValue("Iron Man") // true
    mapOfAvengers.contains("IM") // true
    val values = mapOfAvengers.values
    val key = mapOfAvengers.keys
    val entities = mapOfAvengers.entries
    for (i in entities) {
        println(i.key)
        println(i.value)
    }
    val im = mapOfAvengers["IM"]
    val ca = mapOfAvengers.get("CA")
    val defaultValue = mapOfAvengers.getOrDefault("BW", "Default avenger")
    println(defaultValue)
}

fun creatingMutableHashMap() {
    val mutableMapOf = mutableMapOf(
        "IM" to "Iron Man",
        "CA" to "Captain America",
        "TH" to "Thor",
        "HK" to "Hulk"
    )
    mutableMapOf.putIfAbsent("TH", "Thenos")
    mutableMapOf["BW"] = "Black Widow"
    mutableMapOf.put("TH", "Ththe")
    // put if absent

    // get or put
    mutableMapOf.getOrDefault("BW", "Default")

    println(mutableMapOf)
}

fun filteringAndTransformingMap() {
    val testMap = mutableMapOf<Char, Int>()
    val mutableMapOf = mutableMapOf(
        "IM" to "Iron Man",
        "CA" to "Captain America",
        "TH" to "Thor",
        "HK" to "Hulk"
    )

    mutableMapOf.isEmpty()

//    filter and map

    val result =
        mutableMapOf.filter { it.value.toLowerCase().contains("i") }
            .map { it.value }
    println(result)
//    filter keys and values and map
    val result2 =
        mutableMapOf.filterValues { it.toLowerCase().contains("i") }
            .map { it.value }
    println(result2)
}

fun mapNotNull() {
    val mutableMapOf = mutableMapOf(
        "IM" to "Iron Man",
        "CA" to "Captain America",
        "TH" to "Thor",
        "HK" to "Hulk"
    )

//    mutableMapOf.asSequence()
    val result = mutableMapOf.mapNotNull {  // if this is coming from server
        it.value
    }

}

fun sequenceAsDS() {
    val sequence = sequenceOf(
        People("James Bond"),
        People("Tony Stark"),
        People("Peter Parker")
    )

    sequence.toList()
//    list.asSequence()
}

fun stackUsage() {
    // using ArrayDequeue as stack for faster performance
    val stack = ArrayDeque<String>()
    stack.push("Iron man")
    stack.push("Thor")
    stack.push("Spider man")
//    stack.add("Thor") // add last as queue

    stack.forEach {
        println("foreach stack $it")
    }

    for (name in 0 until stack.size) {
            println("---")
    }
        println("FOr ${stack.pop()}")


}