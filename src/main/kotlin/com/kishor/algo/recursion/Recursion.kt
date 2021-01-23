package com.kishor.algo.recursion

fun main() {
    headRecursion(5)
    tailRecursion(5)
    println("Result ${factorial(10)}")
}

fun headRecursion(n: Int) {
    println("Head recursion call n=$n")
    // base condition
    if (n == 0) return
    // recursion call
    headRecursion(n - 1)
    // some operation
    println("Head recursion for $n")
}

fun tailRecursion(n: Int) {
    println("Tail recursion call n=$n")
    // base condition
    if (n == 0) return
    // some operation
    println("Tail recursion for $n")
    // recursive call
    tailRecursion(n - 1)
}

// factorial with head recursion
fun factorial(n: Int): Int {
    if (n == 1) return 1
    val result = n * factorial(n - 1)
    return result
}

