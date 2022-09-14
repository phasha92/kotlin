sealed class LargeSizedGoods: Product() {
    data class Table(override val weight: Int = 10, override val loadingTime: Long = 3000L): LargeSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Стол #$productNumber"
    }

    data class Fridge(override val weight: Int = 30, override val loadingTime: Long = 30000L): LargeSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Холодильник #$productNumber"
    }

    data class Sofa(override val weight: Int = 25, override val loadingTime: Long = 25000L): LargeSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Диван #$productNumber"
    }

    data class Armchair(override val weight: Int = 10, override val loadingTime: Long = 3000L): LargeSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Кресло #$productNumber"
    }

    data class Bed(override val weight: Int = 15, override val loadingTime: Long = 5000L): LargeSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Кровать #$productNumber"
    }

    data class AirConditioner(override val weight: Int = 10, override val loadingTime: Long = 3000L):
        LargeSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Кондиционер #$productNumber"
    }

    data class Locker(override val weight: Int = 10, override val loadingTime: Long = 3000L): LargeSizedGoods() {
        private val productNumber: Int

        init {
            count++
            productNumber = count
        }

        override fun toString() = "Шкаф #$productNumber"
    }

    companion object {
        private var count = 0
        fun createLargeSizedGoods() =
            listOf(
                Table(),
                Fridge(),
                Sofa(),
                Armchair(),
                Bed(),
                AirConditioner(),
                Locker()
            ).random()
    }
}