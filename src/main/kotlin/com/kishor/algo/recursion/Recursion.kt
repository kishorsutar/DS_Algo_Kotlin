package com.kishor.algo.recursion

fun main() {
//    headRecursion(5)
//    tailRecursion(5)
//    println("Result head ${factorial(10)}")
//    println("Result tail ${factoTail(10)}")
    println("Fibo Head ${headFibonacci(20)}")
    println("Fibo Tail ${tailFibo(100, 0, 1)}")
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

fun factoTail(n: Int): Int {
    return factorial(n, 1)
}

fun factorial(n: Int, accumulator: Int): Int {
    if (n == 1) return accumulator
    return factorial(n - 1, n * accumulator)
}

// head recursion fibonacci number
fun headFibonacci(n: Int): Int {
    if (n == 0) return 0
    if (n == 1) return 1
    val res = headFibonacci(n -1) + headFibonacci(n -2)
    return res
}

fun tailFibo(n: Int, a: Long, b: Long): Long {
    if (n == 0) return a
    if (n == 1) return b
    return tailFibo(n - 1, b, a + b)
}



