package com.kishor.kotlin.oop

fun main() {
    val button = Button()
    button.setListener(onClickListener = object : OnClickListener {
        override fun onClick() {
            println("button clicked setting anonymous")
        }
    })

    button.click()

    // or this
    button.onClickListener = object : OnClickListener {
        override fun onClick() {
            println("button clicked anonymous")
        }
    }

    button.click()

    button.setListener(ViewClickHandler())

    button.click()
}

class ViewClickHandler : OnClickListener {
    override fun onClick() {
        println("view clicked from class implementation")
    }

}

interface OnClickListener {
    fun onClick()
}

open class View {
    lateinit var onClickListener: OnClickListener

    fun setListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }
    fun click() {
        onClickListener.onClick()
    }
}

class Button: View()

