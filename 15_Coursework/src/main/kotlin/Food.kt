sealed class Food: Product() {
    data class Tomatoes(val weight: Int = 5, val loadingTime: Long = 1000L): Food() {
        override fun toString() = "Томаты ${weight}кг"
    }

    data class Cucumbers(val weight: Int = 5, val loadingTime: Long = 1000L): Food() {
        override fun toString() = "Огурцы ${weight}кг"
    }

    data class Broccoli(val weight: Int = 5, val loadingTime: Long = 1000L): Food() {
        override fun toString() = "Брокколи ${weight}кг"
    }

    data class Corn(val weight: Int = 5, val loadingTime: Long = 1000L): Food() {
        override fun toString() = "Кукуруза ${weight}кг"
    }

    data class Sugar(val weight: Int = 15, val loadingTime: Long = 3000L): Food() {
        override fun toString() = "Сахар ${weight}кг"
    }

    data class Salt(val weight: Int = 1, val loadingTime: Long = 100L): Food() {
        override fun toString() = "Соль ${weight}кг"
    }

    data class Potato(val weight: Int = 10, val loadingTime: Long = 3000L): Food() {
        override fun toString() = "Картофель ${weight}кг"
    }

    data class Beef(val weight: Int = 3, val loadingTime: Long = 300L): Food() {
        override fun toString() = "Говядина ${weight}кг"
    }

    data class ChickenMeat(val weight: Int = 10, val loadingTime: Long = 2000L): Food() {
        override fun toString() = "Куриное мясо ${weight}кг"
    }
}