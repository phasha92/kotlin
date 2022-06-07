package machine
    // types of coffee
sealed class Coffee {
    abstract val price: Int
    abstract val milk: Int
    abstract val water: Int
    abstract val coffeeBeans: Int

    object Espresso: Coffee() {
        override val coffeeBeans: Int
            get() = 16
        override val milk: Int
            get() = 0
        override val price: Int
            get() = 4
        override val water: Int
            get() = 250
    }

    object Latte: Coffee() {
        override val coffeeBeans: Int
            get() = 20
        override val milk: Int
            get() = 75
        override val price: Int
            get() = 7
        override val water: Int
            get() = 350
    }

    object Cappuccino: Coffee() {
        override val coffeeBeans: Int
            get() = 12
        override val milk: Int
            get() = 100
        override val price: Int
            get() = 6
        override val water: Int
            get() = 200
    }
}