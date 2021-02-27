package com.kishor.kotlin.algo.recursion


fun main() {
    PrintReverseString().printString("Tony Stark")
}

class PrintReverseString {

    fun printString(s: String) {
        helper(s.toCharArray(), s.length - 1)
    }

    fun helper(charArray: CharArray, index: Int) {
        if (index < 0) return
        print(charArray[index])
        helper(charArray, index-1)
    }


}