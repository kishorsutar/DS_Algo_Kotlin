package com.kishor.ds

import java.util.concurrent.TimeUnit
import kotlin.system.measureNanoTime

fun main(args: Array<String>) {
//    sequece()
//    generatingSequenceAsList()
//    generatingSequence()

//    requireNotNull()
    passingVararg("Green lantern", "Kishor", "Stan lee")
}

fun generatingSequenceAsList() {
//    lateinit var list: List<Int>
    val sequence = getSomeList()
    measure {
        val avg = sequence.asSequence() // collection method to improve performance which has
            // high number of input
            .filter { it % 3 == 0 }
            .average()

        println("As a list -  sequence $avg")
    }

}

private fun getSomeList(): List<Int> {
    val list = generateSequence(1) { it + 1 }
        .take(50_000_000)
        .toList()
    return list
}

fun generatingSequence() {
    measure {
        val sequence = generateSequence(1) { it + 1 }
            .take(50_000_000)
        val avg = sequence.filter { it % 3 == 0 }.average()
        println(avg)
    }
}

fun sequece() {
    measure {
        val list = listOf("Iron Man", "Thor", "SpiderMan")
            .filter {
                println("$it filter")
                true
            }
            .filter {
                println("$it second")
                true
            }.forEach {
                println("$it foreach")
            }
    }

    println("----------------------")
    measure {
        val sequence = sequenceOf("Iron Man", "Thor", "SpiderMan")
            .filter {
                println("$it filter")
                true
            }
            .filter {
                println("$it second")
                true
            }.forEach {
                println("$it foreach")
            }
    }

}

// calculates performance, not the final solutions but to give an idea
fun measure(block: () -> Unit) {
    val nanoSeconds = measureNanoTime(block)
    val miliSec = TimeUnit.NANOSECONDS.toMillis(nanoSeconds)
    println(miliSec)
}

fun requireNotNull() {
    val people: People? = null
    val result = requireNotNull(people, { "Person should not be null" }).name // valuable information for debuging
    println("Person should not be null $result")
}

fun passingVararg(title: String, vararg authors: String) {
    println(title)
    authors.forEach {
        println(it)
    }
}