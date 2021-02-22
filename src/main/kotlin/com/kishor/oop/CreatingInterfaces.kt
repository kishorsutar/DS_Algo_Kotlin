package com.kishor.oop

fun main() {
    val listenerImp: CheckListener = ListenerImpl()
    val listenerImp2: CheckListener = ListenerImpl2("Test")
    listenerImp.check()
    listenerImp2.check()
}

interface CheckListener {
    fun check()
}

class ListenerImpl : CheckListener {
    override fun check() {
        println("Listener called")
    }
}

class ListenerImpl2(val test: String) : CheckListener {
    override fun check() {
        println("$test Listener called Second")
    }
}
