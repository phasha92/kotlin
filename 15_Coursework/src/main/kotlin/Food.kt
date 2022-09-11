sealed class Food: Product() {
    data class Tomatoes(override val weight: Int = 5, override val loadingTime: Long = 1000): Food() {
        override fun toString() = "Томаты ${weight}кг"
    }

    data class Cucumbers(override val weight: Int = 5, override val loadingTime: Long = 1000): Food() {
        override fun toString() = "Огурцы ${weight}кг"
    }

    data class Broccoli(override val weight: Int = 5, override val loadingTime: Long = 1000L): Food() {
        override fun toString() = "Брокколи ${weight}кг"
    }

    data class Corn(override val weight: Int = 1, override val loadingTime: Long = 300): Food() {
        override fun toString() = "Кукуруза ${weight}кг"
    }

    data class Sugar(override val weight: Int = 15, override val loadingTime: Long = 3000): Food() {
        override fun toString() = "Сахар ${weight}кг"
    }

    data class Salt(override val weight: Int = 1, override val loadingTime: Long = 100): Food() {
        override fun toString() = "Соль ${weight}кг"
    }

    data class Potato(override val weight: Int = 10, override val loadingTime: Long = 3000L): Food() {
        override fun toString() = "Картофель ${weight}кг"
    }

    data class Beef(override val weight: Int = 3, override val loadingTime: Long = 1000): Food() {
        override fun toString() = "Говядина ${weight}кг"
    }

    data class ChickenMeat(override val weight: Int = 10, override val loadingTime: Long = 3000): Food() {
        override fun toString() = "Куриное мясо ${weight}кг"
    }

    companion object {
        fun randomFood() =
            listOf(Tomatoes(),
                Cucumbers(),
                Broccoli(),
                Corn(),
                Sugar(),
                Salt(),
                Potato(),
                Beef(),
                ChickenMeat()).random()
    }

}