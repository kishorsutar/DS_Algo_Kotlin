package com.kishor.kotlin.oop

//class BeerBot {
//    fun dispenseBeer() {
//        println("Dispensing Beer")
//    }
//}
//
//class WineBot {
//    fun dispenseWine() {
//        println("Dispensing Wine")
//    }
//}
//
//class RoboPub {
//    private val wineBot = WineBot()
//    private val beerBot = BeerBot()
//
//    fun dispenseDrink() {
//        wineBot.dispenseWine()
//        beerBot.dispenseBeer()
//    }
//}

// changes to

interface DrinksBot {
    fun dispenseDrink()
}

class BeerBot : DrinksBot {
    override fun dispenseDrink() {
        println("Dispensing Beer")
    }
}

class WineBot : DrinksBot {
    override fun dispenseDrink() {
        println("Dispensing Wine")
    }
}

class RoboPub(private val drinksBot: List<DrinksBot>) {
    fun dispenseDrink() {
        drinksBot.forEach {
            it.dispenseDrink()
        }
    }
}
