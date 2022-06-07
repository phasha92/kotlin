package machine

object CoffeeMachine {
    // setters
    private var water = 400
        set(value) {
            field = if (value > 0) value else 0
        }
    private var milk = 540
        set(value) {
            field = if (value > 0) value else 0
        }
    private var coffeeBeans = 120
        set(value) {
            field = if (value > 0) value else 0
        }
    private var cups = 9
        set(value) {
            field = if (value > 0) value else 0
        }
    private var money = 550
        set(value) {
            field = if (value > 0) value else 0
        }

    // print info
    private fun printData() = println(
        """
The coffee machine has:
$water ml of water
$milk ml of milk
$coffeeBeans g of coffee beans
$cups disposable cups
$${money} of money
"""
    )

    // action choice
    fun action() {
        do {
            val x = input("Write action (buy, fill, take, remaining, exit): ")
            when (x) {
                "buy" -> buy()
                "fill" -> fill()
                "take" -> take()
                "remaining" -> printData()
            }
        } while (x != "exit")
    }

    // yes)) this is buy
    private fun buy() {
        println()
        val coffee: Coffee =
            when (input("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")) {
                "1" -> Coffee.Espresso
                "2" -> Coffee.Latte
                "3" -> Coffee.Cappuccino
                "back" -> return
                else -> return print("unknown command\n")
            }
        if (ingredientCalculator(coffee)) cell(coffee)
    }

    // and fill
    private fun fill() {
        water += input("Write how many ml of water do you want to add: ").toInt()
        milk += input("Write how many ml of milk do you want to add: ").toInt()
        coffeeBeans += input("Write how many grams of coffee beans do you want to add: ").toInt()
        cups += input("Write how many disposable cups of coffee do you want to add: ").toInt()
        println()
    }

    // and take :)
    private fun take() {
        println("I gave you \$$money")
        money = 0
        println()
    }

    // serviceability
    private fun ingredientCalculator(coffee: Coffee): Boolean {
        val ingredients = listOf(water > coffee.water,
            milk > coffee.milk,
            coffeeBeans > coffee.coffeeBeans,
            cups > 0)
        val service = ingredients.count { it } == ingredients.size
        if (service) println("I have enough resources, making you a coffee!\n")
        else {
            if (water < coffee.water)
                println("Sorry, not enough water!\n")
            if (milk < coffee.milk)
                println("Sorry, not enough milk!\n")
            if (coffeeBeans < coffee.coffeeBeans)
                println("Sorry, not enough coffee beans!\n")
            if (cups == 0)
                println("Sorry, not enough cups!\n")
        }
        return service
    }

    // beautiful input :)
    private fun input(str: String): String {
        print(str)
        return readln()
    }

    // cell coffee
    private fun cell(coffee: Coffee) {
        water -= coffee.water
        milk -= coffee.milk
        coffeeBeans -= coffee.coffeeBeans
        cups--
        money += coffee.price
    }
}