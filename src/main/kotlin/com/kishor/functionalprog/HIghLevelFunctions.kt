package com.kishor.functionalprog

fun main() {
    Program().sum(3, 4, object : NumberCalculator {
        override fun execute(sum: Int) {
            println("Interface $sum")
        }
    })

    // lambda expression/definition
//    val lambda: (Int) -> Unit = { s: Int -> println("Lambda $s") }

    Program().sum(3, 4) { s: Int -> println("Lambda $s") }
}

class Program{

    fun sum(a: Int, b: Int, action: (Int) -> Unit) {
        action(a+b)
    }

    fun sum(a: Int, b: Int, action: NumberCalculator) {
        val sum = a + b
        action.execute(sum)
    }

     fun sum(a: Int, b: Int) {
        println("Function ${a+b}")
    }
}

interface NumberCalculator {
    fun execute(sum: Int)
}