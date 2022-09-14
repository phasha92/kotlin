sealed class Food: Product() {
    data class Tomatoes(override val weight: Int = 5, override val loadingTime: Long = 1000): Food() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Томаты ${weight}кг #$productNumber"
    }

    data class Cucumbers(override val weight: Int = 5, override val loadingTime: Long = 1000): Food() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Огурцы ${weight}кг #$productNumber"
    }

    data class Broccoli(override val weight: Int = 5, override val loadingTime: Long = 1000L): Food() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Брокколи ${weight}кг #$productNumber"
    }

    data class Corn(override val weight: Int = 1, override val loadingTime: Long = 300): Food() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Кукуруза ${weight}кг #$productNumber"
    }

    data class Sugar(override val weight: Int = 15, override val loadingTime: Long = 3000): Food() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Сахар ${weight}кг #$productNumber"
    }

    data class Salt(override val weight: Int = 1, override val loadingTime: Long = 100): Food() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Соль ${weight}кг #$productNumber"
    }

    data class Potato(override val weight: Int = 10, override val loadingTime: Long = 3000L): Food() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Картофель ${weight}кг #$productNumber"
    }

    data class Beef(override val weight: Int = 3, override val loadingTime: Long = 1000): Food() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Говядина ${weight}кг #$productNumber"
    }

    data class ChickenMeat(override val weight: Int = 10, override val loadingTime: Long = 3000): Food() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Куриное мясо ${weight}кг #$productNumber"
    }

    companion object {
        private var count = 0
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