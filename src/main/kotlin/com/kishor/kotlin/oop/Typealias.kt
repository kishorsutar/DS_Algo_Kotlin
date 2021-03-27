package com.kishor.kotlin.oop

typealias AuthToken = String

fun main() {
    val user = User("Kishor", "90990-kjsdh-28wuhqiu-iwjBN0")
    user.authToken // as string
}


data class User(val name: String, val authToken: AuthToken)

data class Account(val authToken: AuthToken)

data class Order(val authToken: AuthToken)