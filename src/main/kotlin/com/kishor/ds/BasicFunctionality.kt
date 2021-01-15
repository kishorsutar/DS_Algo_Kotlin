package com.kishor.ds

fun main() {
//    conditionals()
//    referntialEquality()
//    functionInsideFunction()
//    singleLineExpression()
//    namedArgumentMagic()
//
//    // vararg type functions
//    passingVarargsToFunction(
//        "Marvels",
//        "Avengers",
//        "Civil War",
//        "Thor:Ragnarok"
//    )

    // for loops
//    forLoopsKotlin()

//    whileLoops()
//    forEachOnCollections()
//    combinWithWUniqueOperator()
//    iterateWithIndexed()
//    rangesInKotlin()
    ternaryOperator()
}


fun conditionals() {

    val calories = 1200

    if (calories > 2000) {
        println("Calories exceeded")
    } else if (calories > 1500) {
        println("Calories almost there")

    } else {
        println("Calories deffecient")
    }


    //single line conditionals
    if (calories > 2000) println("Calories exceeded") else println("calories defficient")

}

fun truthTables() {
    val calories = 1200

    if (calories < 5000 && calories > 2300) {
        println("both are true")
    }

    if (calories < 3000 || calories > 800) {
        println("either of them is true")
    }
}

fun structuralEquality() {
    val name1 = "Kishor"
    val name2 = "James"

    println(name1 == name2)
    println(name1.equals(name2))
    println(name1 != name2)
}

fun referntialEquality() {
    // === equality
    // !== inEquality

    // number, char, boolean
    val num1 = 100
    val num2 = 100
    val char1 = 'd'
    val char2 = 'd'
    println(num1 !== num2)
    println(char1 === char2)

    val per1 = Person("Kishor")
    val per2 = Person("Kishor")
    println(per1 === per2)

}

fun elvisOpertaor(): Int {
    val elvis: Int? = 90

    // nullable check on left hand side
    return elvis ?: 0
}

data class Person(val name: String)

fun functionInsideFunction() {

    println("first function")

    fun secondFunction() {
        println("second function")
    }

    secondFunction()
}

fun singleLineExpression() {

    val age = 32

    fun ageEligibility() = if (age > 21) println("Eligible") else println("Not eligible")

    ageEligibility()
}

fun isFunctionAllowed() = "Its valid"

fun namedArgumentMagic() {
    namedArgFunction(
        age = 32,
        name = "Kishor",
        place = "London",
        isMarried = true
    )
}

fun namedArgFunction(
    age: Int, name: String, place: String, isHealthy: Boolean = true,
    isMarried: Boolean = false
) {

    println("$age of person $name from $place and the person is healthy $isHealthy")
}

// varargs
fun passingVarargsToFunction(movie: String, vararg titles: String) {
    println("$movie movies I like are: ")
    titles.forEach { name -> println(name) }
}

// for loops
fun forLoopsKotlin() {
    val values = listOf("Kishor", "Rupali", "Manya", "Snehal", "Omkya")

    for (value in values) {
        println(value)
    }

    for (i in values.indices) {
        println(values[i])
    }

    for ((index, value) in values.withIndex()) {
        println("THe value at $index is $value")
    }

    for (i in 0 until 10) {
        println(i)
    }

    for (i in 0 until 100 step 5) {
        println(i)
    }

    for (i in 100 downTo 0 step 5) {
        println(i)
    }
}

fun whileLoops() {
    var x = 0
    while (x <= 20) {
        println(x)
        x++
    }
}

fun forEachOnCollections() {
    val peopleList = listOf(
        People("Kishor Sutar"),
        People("James Bond"),
        People("Thor"),
        People("Iron Man")

    )
    // foraeach
    peopleList.forEach { println(it) }
    // map
    peopleList.map { it.name.toUpperCase() }.forEach { println(it.reversed()) }
}

fun combinWithWUniqueOperator() {
    val peopleList = listOf(
        People("Kishor Sutar"),
        People("James Bond"),
        People("Thor"),
        People("Iron Man")

    )

    val morePeople = listOf(
        People("Captain Amercia"),
        People("Black Widow"),
        People("Thanos"),
        People("Dr. Strange"),
        People("Thor"),
        People("Iron Man")
    )

    val uniqueValues = peopleList.union(morePeople).union(listOf(People("Kishor")))
    println(uniqueValues)

}

fun iterateWithIndexed() {
    val morePeople = listOf(
        People("Captain Amercia"),
        People("Black Widow"),
        People("Thanos"),
        People("Dr. Strange"),
        People("Thor"),
        People("Iron Man")
    )

    morePeople.forEachIndexed { index, people ->
        println("For each $index in $people")
    }
}

fun rangesInKotlin() {
    val i = 19
    if (i in 0..10) {
        println("Yes")
    } else {
        println("No")
    }

    for (j in 0..10 step 2) {
        println(j)
    }
}

data class People(val name: String)

fun ternaryOperator() {
    val str: String? = ""

    val result = str ?: "Default"

    println(result)
}

