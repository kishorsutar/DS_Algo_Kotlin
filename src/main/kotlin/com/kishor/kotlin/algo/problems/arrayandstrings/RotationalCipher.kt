package com.kishor.kotlin.algo.problems.arrayandstrings

fun main(args: Array<String>) {
    println(rotationalCipher("abcdefghijklmNOPQRSTUVWXYZ0123456789", 39))
}

fun rotationalCipher(input: String, rotationFactor: Int): String {
    val stringBuilder = StringBuilder()
    for (ele in input) {
        if (ele.toInt() in 65..90 || ele.toInt() in 97..122) {
            stringBuilder.append(getAlphabet(ele,rotationFactor))
        } else if (ele.toInt() in 48..57) {
            stringBuilder.append(getNumericValue(ele, rotationFactor))
        } else {
            stringBuilder.append(ele)
        }
    }
    return stringBuilder.toString()
}

fun getAlphabet(char: Char, k: Int): Char {
    return if (char.toInt() in 65..90) {
        (((char - 'A' + k) % 26) + 'A'.toInt()).toChar()
    } else {
        (((char - 'a' + k) % 26) + 'a'.toInt()).toChar()
    }

}

fun getNumericValue(char: Char, k: Int): Char {
    return  (((char - '0' + k) % 10) + '0'.toInt()).toChar()
}